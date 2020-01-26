package com.grp.springapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.grp.springapp.springbootadminclient.SpringBootAdminClientApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAdminClientApplication.class)
public class SpringContextIntegrationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}