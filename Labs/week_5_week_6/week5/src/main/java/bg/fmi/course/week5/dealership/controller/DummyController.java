package bg.fmi.course.week5.dealership.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @GetMapping("/test")
    public String dummy() {
        return "hello, dummy TEST";
    }
}
