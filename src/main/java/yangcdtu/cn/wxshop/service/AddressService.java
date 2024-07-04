package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yangcdtu.cn.wxshop.dto.address.AddressSaveDTO;
import yangcdtu.cn.wxshop.entity.Address;
import yangcdtu.cn.wxshop.vo.address.AddressDetailVO;
import yangcdtu.cn.wxshop.vo.address.AddressVO;

import java.util.List;

public interface AddressService extends IService<Address> {
    List<AddressVO> getAddressList();
    void saveAddress(AddressSaveDTO address);
    AddressDetailVO getDetail(Long id);
    void updateAddress(AddressSaveDTO address);
}
