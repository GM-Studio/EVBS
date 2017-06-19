package controllertest;

import com.evbs.controller.UserController;
import com.evbs.MainApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by squirrel-chen on 6/18/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MainApplication.class})
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mvc;

    //创建测试上下文
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    //测试方法
    @Test
    public void testController() {
        try {
            this.mvc.perform(get("/com/evbs/test")).andExpect(status().isOk());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
