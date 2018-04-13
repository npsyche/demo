package com.example.demo;

import com.example.demo.web.HelloController;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration//开启web应用的配置，用于模拟ServletContext
@Ignore
public class DemoApplicationTests {

    //用于模拟调用Controller的接口发起请求，在@Test定义的hello测试用例中。perferm函数执行一次请求调用，accept用于执行接受的数据类型
    //andExpect用于判断接口返回的期望值
    private MockMvc mvc;

    @Before//JUnit定义在测试用例@Test内容执行前预加载的内容，这里用来初始化对HelloController的模拟
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void contextLoads() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }

    public MockMvc getMvc() {
        return mvc;
    }

    public void setMvc(MockMvc mvc) {
        this.mvc = mvc;
    }

}
