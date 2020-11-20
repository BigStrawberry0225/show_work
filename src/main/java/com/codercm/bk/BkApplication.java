package com.codercm.bk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

public class BkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BkApplication.class, args);
    }

}

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
