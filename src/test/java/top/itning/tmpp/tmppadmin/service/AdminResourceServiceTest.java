package top.itning.tmpp.tmppadmin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.itning.tmpp.tmppadmin.pojo.AdminUserRole;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminResourceServiceTest {
    @Autowired
    private AdminResourceService adminResourceService;

    @Autowired
    private AdminUserRoleService adminUserRoleService;

    @Test
    public void getAllAdminResources() {
    }

    @Test
    public void getAdminResourceById() {
    }

    @Test
    public void saveAdminResource() {
        List<AdminUserRole> adminUserRoles = adminUserRoleService.getAdminUserRoles();
        for (int i = 0; i < 1000; i++) {
            int index = (int) (Math.random() * adminUserRoles.size());
            adminResourceService.saveAdminResource("/" + UUID.randomUUID().toString().replace("-", ""),
                    getRandomMethod(),
                    new int[]{adminUserRoles.get(index).getId()});
        }
    }

    @Test
    public void delAdminResource() {
    }

    @Test
    public void upAdminResource() {
    }

    private String getRandomMethod() {
        int v = (int) (Math.random() * 10);
        if (v < 4) {
            return "GET";
        } else if (v < 8) {
            return "POST";
        } else {
            return "DELETE";
        }
    }
}