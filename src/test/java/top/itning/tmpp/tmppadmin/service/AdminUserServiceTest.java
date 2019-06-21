package top.itning.tmpp.tmppadmin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserServiceTest {
    @Autowired
    private AdminUserService adminUserService;

    @Test
    public void getAdminUsers() {

    }

    @Test
    public void delAdminUserById() {
    }

    @Test
    public void addAdminUser() {
        for (int i = 0; i < 1000; i++) {
            adminUserService.addAdminUser(
                    UUID.randomUUID().toString().replace("-", ""),
                    UUID.randomUUID().toString().replace("-", ""),
                    getRandomUserType());
        }
    }

    private String getRandomUserType() {
        int v = (int) (Math.random() * 10);
        if (v < 4) {
            return "T";
        } else if (v < 8) {
            return "O";
        } else {
            return "A";
        }
    }
}