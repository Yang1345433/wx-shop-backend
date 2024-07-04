package yangcdtu.cn.wxshop.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yangcdtu.cn.wxshop.dto.address.AddressDeleteDTO;
import yangcdtu.cn.wxshop.dto.address.AddressSaveDTO;
import yangcdtu.cn.wxshop.entity.Address;
import yangcdtu.cn.wxshop.service.AddressService;
import yangcdtu.cn.wxshop.vo.address.AddressDetailVO;
import yangcdtu.cn.wxshop.vo.address.AddressVO;

import java.util.List;

@Tag(name = "地址")
@RestController
@RequestMapping("address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("list")
    @Operation(summary = "列表")
    public List<AddressVO> getAddressList() {
        return addressService.getAddressList();
    }

    @PostMapping("save")
    @Operation(summary = "保存")
    public void saveAddress(@RequestBody AddressSaveDTO address) {
        if (address.getId() == 0) addressService.saveAddress(address);
        else addressService.updateAddress(address);
    }

    @GetMapping("detail")
    @Operation(summary = "详细")
    public AddressDetailVO getAddressDetail(@RequestParam Long id) {
        return addressService.getDetail(id);
    }

    @PostMapping("delete")
    @Operation(summary = "删除")
    public void deleteAddress(@RequestBody AddressDeleteDTO addressDelete) {
        Address address = addressService.getById(addressDelete.getId());
        addressService.removeById(addressDelete.getId());

        if (address.getIsDefault()) {
            List<AddressVO> addressList = addressService.getAddressList();

            if (!addressList.isEmpty()) {
                addressService.update(new LambdaUpdateWrapper<Address>()
                        .eq(Address::getId, addressList.get(0).getId())
                        .set(Address::getIsDefault, true)
                );
            }
        }
    }
}
