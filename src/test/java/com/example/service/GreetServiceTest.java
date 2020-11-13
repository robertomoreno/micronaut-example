package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GreetServiceTest {

  GreetService service;

  @BeforeEach
  public void setup() {
    service = new GreetService();
  }

  @Test
  public void greetingTest() {
    String generateGreet = service.generateGreet("world");
    assertEquals("hello world", generateGreet);
  }

}
