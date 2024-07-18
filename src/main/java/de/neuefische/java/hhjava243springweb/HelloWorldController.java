package de.neuefische.java.hhjava243springweb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {

    @GetMapping
    public String helloWorld() {
        System.out.println("HALLOOOOOOOO");
        return "Hello World";
    }

    @GetMapping("/bye")
    public String byeWorld() {
        System.out.println("BYEEEEE");
        return "bye World";
    }

    @PostMapping
    public String text(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return requestBody;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        System.out.println(id);
        return id;
    }
}
