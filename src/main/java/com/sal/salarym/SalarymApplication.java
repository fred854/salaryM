package com.sal.salarym;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.sal.*")
@MapperScan(value = "com.sal.dao")
@EnableSwagger2
@EnableCaching
public class SalarymApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalarymApplication.class, args);
    }

}
