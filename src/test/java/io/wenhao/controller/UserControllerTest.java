package io.wenhao.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
//        this.mockMvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getUser() throws Exception {
    }

    @Test
//    @Transactional
    public void addUser() throws Exception {
//        String json = "{\"email\": \"qiaowenhao@gmail.com\"," +
//                "\"name\": \"文昊\"," +
//                "\"password\": \"hao1128\"," +
//                "\"school\": \"建大\"," +
//                "\"sex\": \"男\"," +
//                "\"experience\": \"老牛逼了\"}";
//
//        User user = new User();
//        user.setEmail("qiaowenhao@gmail.com");
//
//        mockMvc.perform(
//                post("/api/users/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json.getBytes()))
//                .andExpect(status().isCreated())
//                .andDo(print());
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

}