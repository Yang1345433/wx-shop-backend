package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.dto.address.AddressSaveDTO;
import yangcdtu.cn.wxshop.entity.Address;
import yangcdtu.cn.wxshop.mapper.AddressMapper;
import yangcdtu.cn.wxshop.security.SecurityUser;
import yangcdtu.cn.wxshop.service.AddressService;
import yangcdtu.cn.wxshop.service.RegionService;
import yangcdtu.cn.wxshop.vo.address.AddressDetailVO;
import yangcdtu.cn.wxshop.vo.address.AddressVO;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    private final RegionService regionService;
    @Override
    public List<AddressVO> getAddressList() {
        return this.list(
                new LambdaQueryWrapper<Address>()
                        .eq(Address::getUserId, SecurityUser.getUserId())
                        .orderByDesc(Address::getIsDefault)
        ).stream().map(this::toAddressVO).toList();
    }

    @Override
    public void saveAddress(AddressSaveDTO address) {
        updateAddressIsDefaultToFalse(address);

        this.save(AddressSaveToAddress(address));
    }

    @Override
    public AddressDetailVO getDetail(Long id) {
        return toAddressDetailVO(this.getById(id));
    }

    @Override
    public void updateAddress(AddressSaveDTO address) {
        updateAddressIsDefaultToFalse(address);

        this.updateById(AddressSaveToAddress(address));
    }

    private void updateAddressIsDefaultToFalse(AddressSaveDTO address) {
        if (address.getIsDefault()) {
            List<Address> addresses = this.list(
                    new LambdaQueryWrapper<Address>()
                            .eq(Address::getUserId, SecurityUser.getUserId())
            );

            if (!addresses.isEmpty()) {
                addresses.forEach(item -> item.setIsDefault(false));
                this.updateBatchById(addresses);
            }
        }
    }

    private AddressDetailVO toAddressDetailVO(Address address) {
        return new AddressDetailVO(
                address.getId(),
                address.getProvinceId(),
                address.getCityId(),
                address.getAreaId(),
                address.getAddress(),
                address.getMobile(),
                address.getName(),
                address.getIsDefault(),
                regionService.getById(address.getProvinceId()).getName(),
                regionService.getById(address.getCityId()).getName(),
                regionService.getById(address.getAreaId()).getName()
        );
    }

    private Address AddressSaveToAddress(AddressSaveDTO address) {
        Long id = address.getId() == 0 ? null : address.getId();
        return new Address(
                id,
                SecurityUser.getUserId(),
                address.getAddress(),
                address.getProvinceId(),
                address.getCityId(),
                address.getAreaId(),
                address.getMobile(),
                address.getName(),
                address.getIsDefault()
        );
    }

    private AddressVO toAddressVO(Address address) {
        String province = regionService.getById(address.getProvinceId()).getName();
        String city = regionService.getById(address.getCityId()).getName();
        String area = regionService.getById(address.getAreaId()).getName();

        return new AddressVO(
                address.getId(),
                province + " " + city + " " + area + " " + address.getAddress(),
                address.getMobile(),
                address.getName(),
                address.getIsDefault()
        );
    }
}
