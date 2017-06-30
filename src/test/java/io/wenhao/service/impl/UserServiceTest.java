package io.wenhao.service.impl;

import io.wenhao.model.UserModel;
import io.wenhao.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private IUserService service;

    @Test
    @Transactional
    public void addUser() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setPassword("1234567890");
        userModel.setEmail("qiaowenhao@gmail.com");
        userModel.setName("乔文昊");
        userModel.setExperience("经验丰富");
        userModel.setGrade("一年级");
        userModel.setSchool("某个学校");
        userModel.setSex("男");

        Integer count = service.addUser(userModel);
        assertEquals((long) (count), 1L);
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
//        UserModel userModel = new UserModel();
//        userModel.setEmail("11111");
//        userModel.setName("admin");
//        userModel.setPassword("123");
//        userModel.setSalt("sdfs");
//
//        UserModel result = service.getUser("11111");
//        assertEquals(userModel, result);
    }

    @Test
    public void login() throws Exception {
    }

    @Test
    public void register() throws Exception {
    }

}