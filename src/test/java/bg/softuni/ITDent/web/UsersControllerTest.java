package bg.softuni.ITDent.web;

import bg.softuni.ITDent.repository.UserRepository;
import bg.softuni.ITDent.repository.UserRoleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class UsersControllerTest {

    private static final String USER_CONTROLLER_PREFIX = "/users";
    private long testUserId;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    private AllTestData testData;

    @BeforeEach
    public void setup(){
     testData = new AllTestData(userRepository,userRoleRepository);
        testData.init();
        testUserId = testData.getTestUserId();
    }

    @AfterEach
    public void tearDown(){
      testData.cleanUp();
    }

    @Test
    void registerUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post(USER_CONTROLLER_PREFIX + "/register")
        .param("Username","TestName")
        .param("fullName", "TEST TEST")
        .param("email","test@mail.bg")
        .param("number","0888202020")
        .param("age","23")
        .param("password","test")
        .param("roles","USER")
        .with(csrf())).andExpect(status().is3xxRedirection());

        Assertions.assertEquals(2, userRepository.count());

    }




}
