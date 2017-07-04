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
public class LoginControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void login() throws Exception {
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
//                post("/api/login/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json.getBytes()))
//                .andExpect(status().isOk())
//                .andDo(print());
    }

    @Test
    public void logout() throws Exception {
    }

}