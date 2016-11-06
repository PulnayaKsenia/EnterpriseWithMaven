package ua.goit.java.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="helloBean")
    public Test helloWorld() {
        Test test = new Test();
        test.setAge(234);
        test.setName("dfbvsfvsfv");
        return test;
    }

}