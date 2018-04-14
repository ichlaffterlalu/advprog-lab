package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GenericRunnerTest {

    @Test
    public void applicationRunTest() {
        Application.main(new String[]{
            "--spring.main.web-environment=false",
            "--spring.autoconfigure.exclude=blahblahblah",
            // Override any other environment properties according to your needs
        });
    }
}
