package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.bo.AttributeBO;
import yangcdtu.cn.wxshop.bo.IssueBO;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.dto.goods.GoodListQuery;
import yangcdtu.cn.wxshop.entity.*;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.mapper.*;
import yangcdtu.cn.wxshop.service.BrandService;
import yangcdtu.cn.wxshop.service.GoodsService;
import yangcdtu.cn.wxshop.vo.goods.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    private final MinioService minioService;
    private final ProductMapper productMapper;
    private final SpecificationMapper specificationMapper;
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;
    private final BrandService brandService;
    @Override
    public GoodsPage getGoodsPageByCategory(GoodListQuery query) {
        Page<Goods> page = this.page(
                Page.of(query.getPage(), query.getSize()),
                new LambdaQueryWrapper<Goods>()
                        .eq(Goods::getCategoryId, query.getCategoryId())
        );
        return new GoodsPage(
                page.getRecords().stream().map(this::toGoodsVO).toList(),
                page.getPages(),
                Collections.emptyList()
        );
    }

    @Override
    public GoodsDetailVO getGoodsDetail(Long id) {
        return toGoodsDetailVO(
                this.getById(id),
                specificationMapper.selectList(
                        new LambdaQueryWrapper<Specification>()
                                .eq(Specification::getGoodsId, id)
                ),
                productMapper.selectList(
                        new LambdaQueryWrapper<Product>()
                                .eq(Product::getGoodsId, id)
                )
        );
    }

    @Override
    public CommentVO getCommentVO(Long goodsId) {
        List<Comment> comments = commentMapper.selectList(
                new LambdaQueryWrapper<Comment>()
                        .eq(Comment::getGoodsId, goodsId)
        );

        Map<Long, List<Comment>> userComment = comments.stream().collect(Collectors.groupingBy(Comment::getUserId));
        Map<Long, User> userMap = new HashMap<>();

        userComment.forEach((userId, value) -> userMap.put(userId, userMapper.selectById(userId)));

        return new CommentVO(
                comments.size(),
                comments.stream().map(item -> toCommentDetailVO(item, userMap.get(item.getUserId()))).toList()
        );
    }

    @Override
    public GoodsPage getGoodsPageByBrand(GoodListQuery query) {
        Page<Goods> page = this.page(
                Page.of(query.getPage(), query.getSize()),
                new LambdaQueryWrapper<Goods>()
                        .eq(Goods::getBrandId, query.getBrandId())
        );
        return new GoodsPage(
                page.getRecords().stream().map(this::toGoodsVO).toList(),
                page.getPages(),
                Collections.emptyList()
        );
    }

    private CommentDetailVO toCommentDetailVO(Comment comment, User user) {
        return new CommentDetailVO(
                user.getAvatarUrl(),
                user.getName(),
                comment.getAddTime(),
                comment.getContent(),
                comment.getPicList().getUrls().stream().map(item -> minioService.getUrlForDownload(MinioBucketEnum.COMMENT.getCode(), item)).toList()
        );
    }

    private GoodsDetailVO toGoodsDetailVO(Goods goods, List<Specification> specifications, List<Product> products) {
        Map<String, List<Specification>> collect = specifications.stream().collect(Collectors.groupingBy(Specification::getSpec));

        ArrayList<SpecificationVO> specificationVOS = new ArrayList<>();
        collect.forEach((key, value) -> specificationVOS.add(toSpecificationVO(key, value.stream().map(this::toSpecificationValueVO).toList())));

        return new GoodsDetailVO(
                toGoodsInfoVO(goods),
                specificationVOS,
                products.stream().map(this::toProductVO).toList(),
                toBrandVO(brandService.getById(goods.getBrandId())),
                getCommentVO(goods.getId()),
                goods.getOtherInfo().getAttribute().stream().map(this::toAttributeVO).toList(),
                goods.getOtherInfo().getIssue().stream().map(this::toIssueVO).toList(),
                Collections.emptyList()
        );
    }

    private BrandVO toBrandVO(Brand brand) {
        return new BrandVO(brand.getId(), brand.getName());
    }

    private SpecificationVO toSpecificationVO(String spec, List<SpecificationValueVO> specificationValueVOS) {
        specificationValueVOS.get(0).setChecked(true);
        return new SpecificationVO(specificationValueVOS, spec);
    }

    private SpecificationValueVO toSpecificationValueVO(Specification specification) {
        return new SpecificationValueVO(
                specification.getId(),
                false,
                specification.getValue(),
                specification.getSpec()
        );
    }

    private ProductVO toProductVO(Product product) {
        return new ProductVO(product.getId(), product.getPrice(), product.getSpecifications(), product.getNumber());
    }

    private AttributeVO toAttributeVO(AttributeBO attribute) {
        return new AttributeVO(attribute.getAttribute(), attribute.getValue());
    }

    private IssueVO toIssueVO(IssueBO issue) {
        return new IssueVO(issue.getQuestion(), issue.getAnswer());
    }

    private GoodsInfoVO toGoodsInfoVO(Goods goods) {
        String picUrl = minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl());
        return new GoodsInfoVO(
                goods.getId(),
                Stream.concat(
                        Stream.of(picUrl),
                        goods.getOtherInfo().getGallery().stream().map(item -> minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), item)).toList().stream()
                ).toList(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                goods.getName(),
                goods.getBrief(),
                goods.getCounterPrice(),
                goods.getRetailPrice(),
                goods.getDetail()
        );
    }

    private GoodsVO toGoodsVO(Goods goods) {
        return new GoodsVO(
                goods.getId(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                goods.getName(),
                goods.getRetailPrice()
        );
    }
}
