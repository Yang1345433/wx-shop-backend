package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Address;

import java.util.List;

@SpringBootTest
public class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void saveAddressList() {
        List<Address> addresses = List.of(
                new Address(
                        null,
                        1L,
                        "成都工业学院",
                        1054L,
                        3941L,
                        3998L,
                        "18357894352",
                        "杨建明",
                        true
                ),
                new Address(
                        null,
                        1L,
                        "电子科技大学",
                        1054L,
                        3941L,
                        3998L,
                        "18357894352",
                        "王浩",
                        true
                )
        );

        addressService.saveBatch(addresses);
    }
}
