package sk.zemco.appslabspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/snailDistance")
    public static double snailDistance(
            @RequestParam double stepHeight,
            @RequestParam double stepLength,
            @RequestParam double towerHeight
    ) {
        double stepCount = towerHeight / stepHeight;
        return stepCount * stepLength + towerHeight;
    }

}
