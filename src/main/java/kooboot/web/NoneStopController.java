package kooboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class NoneStopController {

    @Autowired
    Environment environment;

    @GetMapping("/profile")
    public String profile() {
        return Arrays.asList(environment.getActiveProfiles()).stream().findFirst().orElse("");
    }
}
