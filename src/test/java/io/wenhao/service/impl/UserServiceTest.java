package io.wenhao.service.impl;

import io.wenhao.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private IUserService service;

    @Test
//    @Transactional
    public void addUser() throws Exception {
//        User user = new User();
//        user.setPassword("1234567890");
//        user.setEmail("qiaowenhao@gmail.com");
//        user.setName("乔文昊");
//        user.setUserName("wenhao");
//        user.setExperience("经验丰富");
//        user.setGrade("一年级");
//        user.setSchool("某个学校");
//        user.setSex("男");
//
//        Integer count = service.addUser(user);
//        assertEquals((long) (count), 1L);
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

    @Test
    public void getUserByUserName() throws Exception {
//        User user = new User();
//        user.setPassword("1234567890");
//        user.setEmail("qiaowenhao@gmail.com");
//        user.setName("乔文昊");
//        user.setUserName("wenhao");
//        user.setExperience("经验丰富");
//        user.setGrade("一年级");
//        user.setSchool("某个学校");
//        user.setSex("男");
//
//        User result = service.getUserByName("wenhao");
//        assertEquals(user, result);
    }
}