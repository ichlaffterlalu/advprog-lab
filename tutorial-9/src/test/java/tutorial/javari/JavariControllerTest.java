package tutorial.javari;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JavariControllerTest {
    // TODO Implement me! (additional task)

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAnimalByIdTest() throws Exception {
        this.mockMvc.perform(get("/javari/2")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"));
    }

    @Test
    public void getByIdNotFoundTest() throws Exception {
        this.mockMvc.perform(get("/javari/203")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.msgType").value("warning"));
    }

    @Test
    public void getAllAnimals() throws Exception {
        this.mockMvc.perform(get("/javari")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[1].id").value("2"));
    }
}
