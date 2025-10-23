package com.felipe.github_actions_test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTest {

    @Test
    void testHello(){
        HelloController helloController = new HelloController();
        String response = helloController.hello();
        assertThat(response).isEqualTo("Hello, world!");
    }
}
