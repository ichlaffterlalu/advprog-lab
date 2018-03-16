package hello;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CVController.class)
public class CVControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cvWithVisitor() throws Exception {
        mockMvc.perform(get("/cv").param("visitor", "Arief"))
                .andExpect(content().string(containsString("Arief, I hope you&#39;re interested to hire me")))
                .andExpect(content().string(not("This is my CV")));
    }

    @Test
    public void cvWithoutVisitor() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("This is my CV")))
                .andExpect(content().string(not(", I hope you&#39;re interested to hire me")));
    }

    @Test
    public void cvWithNoNameVisitor() throws Exception {
        mockMvc.perform(get("/cv").param("visitor", ""))
                .andExpect(content().string(containsString("This is my CV")))
                .andExpect(content().string(not(", I hope you&#39;re interested to hire me")));
    }

    @Test
    public void checkCVFullName() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("Ichlasul Affan")))
                .andExpect(content().string(not("Okita Souji")));
    }

    @Test
    public void checkCVBirthDate() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("12 March 1999")))
                .andExpect(content().string(not("22 January 2000")));
    }

    @Test
    public void checkCVBirthPlace() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("Padang")))
                .andExpect(content().string(not("Brisbane")));
    }

    @Test
    public void checkCVAddress() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("Perumahan Bukit Dago, A1/10, " +
                        "Rawakalong, Gunung Sindur, Bogor, West Java, Indonesia 16340")))
                .andExpect(content().string(not("Sesame Street")));
    }

    @Test
    public void checkCVElementarySchool() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("SD Islam Al-Amanah Bakti Jaya")))
                .andExpect(content().string(not("Pythonia Park")));
    }

    @Test
    public void checkCVMiddleSchool() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("MTsN Tangerang II Pamulang")))
                .andExpect(content().string(not("SMP Negeri 1 Kota Tangerang Selatan")));
    }

    @Test
    public void checkCVHighSchool() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("MAN Serpong")))
                .andExpect(content().string(not("SMA Negeri 2 Kota Tangerang Selatan")));
    }

    @Test
    public void checkCVUniversity() throws Exception {
        mockMvc.perform(get("/cv"))
                .andExpect(content().string(containsString("University of Indonesia")))
                .andExpect(content().string(not("Oxford University")));
    }

    @Test
    public void checkCVEssay() throws Exception {
        String goodEssay = "I am 19 years old. Currently pursuing my Computer Science " +
                "bachelor degree at University of Indonesia. Interested in network " +
                "security and operating systems. I have experiences in teaching assistant " +
                "of Foundations of Programming. Also interested in front end web development.";
        String badEssay = "I have four cats.";

        mockMvc.perform(get("/cv"))
                .andExpect(content().string(not(goodEssay)))
                .andExpect(content().string(not(badEssay)));
    }

}