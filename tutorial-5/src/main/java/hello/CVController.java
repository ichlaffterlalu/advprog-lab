package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CVController {

    Map<String, String> cvInformations = new HashMap<>();

    @GetMapping("/cv")
    public String cv(@RequestParam(name = "visitor", required = false)
                             String visitor, Model model) {

        if(visitor == null || visitor.equals("")) {
            model.addAttribute("visitorMessage", "This is my CV");
        }
        else {
            model.addAttribute("visitorMessage", visitor+", I hope youre interested to hire me");
        }
        buildAttrs();
        model.addAllAttributes(cvInformations);
        return "cv";

    }

    private void buildAttrs() {
        cvInformations.put("owner", "Ichlasul Affan");
        cvInformations.put("birthDate", "12 March 1999");
        cvInformations.put("birthPlace", "Padang");
        cvInformations.put("address", "Perumahan Bukit Dago, A1/10, Rawakalong, Gunung Sindur," +
                "Bogor, West Java, Indonesia 16340");
        cvInformations.put("elemSchool", "SD Islam Al-Amanah Bakti Jaya");
        cvInformations.put("midSchool", "MTsN Tangerang II Pamulang");
        cvInformations.put("highSchool", "MAN Serpong");
        cvInformations.put("univ", "University of Indonesia");
        cvInformations.put("essay", "I am 19 years old. Currently pursuing my Computer Science " +
                "bachelor degree at University of Indonesia. Interested in network security and " +
                "operating systems. I have experiences in teaching assistant of Foundations " +
                "of Programming. Also interested in front end web development.");
    }

}