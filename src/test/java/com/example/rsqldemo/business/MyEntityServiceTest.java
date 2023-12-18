package com.example.rsqldemo.business;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class MyEntityServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MyEntityService myEntityService;

    @AfterEach
    void tearDown() {
        myEntityService.removeAll();
    }

    @Test
    void findByName() {
        myEntityService.add(myEntity("first", "ABCD"));
        myEntityService.add(myEntity("second", "AQWE"));

        var result = myEntityService.findByRsql("name=like='fir'", Pageable.unpaged());

        assertEquals(1, result.getTotalElements());
    }

    @Test
    void findByBicIlike() {
        myEntityService.add(myEntity("first", "ABCD"));
        myEntityService.add(myEntity("second", "AQWE"));

        var result = myEntityService.findByRsql("bic=ilike='ABC'", Pageable.unpaged());

        assertEquals(1, result.getTotalElements());
    }

    @Test
    void findByBicLike() {
        myEntityService.add(myEntity("first", "ABCD"));
        myEntityService.add(myEntity("second", "AQWE"));

        var result = myEntityService.findByRsql("bic=like='ABC'", Pageable.unpaged());

        assertEquals(1, result.getTotalElements());
    }

    private MyEntity myEntity(String name, String bic) {
        var myEntity = new MyEntity();
        myEntity.setName(name);
        myEntity.setBic(Bic.of(bic));
        return myEntity;
    }

}