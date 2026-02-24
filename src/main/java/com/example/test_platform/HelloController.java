package com.example.test_platform;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "🎉 恭喜！Spring Boot Web 服务已成功运行！";
    }
}
