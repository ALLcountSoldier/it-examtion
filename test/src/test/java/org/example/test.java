package org.example;


import org.example.service.FruitsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class test {
    @Autowired
    private FruitsService fruitsService;

        @Test
        void one() {
            double count = fruitsService.test(1, 2, 5,2);
            System.out.println("总金额");
            System.out.println(count);
        }

    }
