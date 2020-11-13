package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.service.GreetService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class GreetControllerIntegrationTest {

  @Inject @Client("/greet") HttpClient client;

  @Inject GreetService greetService;
  @MockBean(GreetService.class)
  GreetService mathService() {
    return mock(GreetService.class);
  }

  @Test
  public void testGreeting() {
    String name = "world";
    String generatedGreeting = "blabla " + name;

    when(greetService.generateGreet(eq(name))).thenReturn(generatedGreeting);

    String response = client.toBlocking().retrieve(HttpRequest.GET(name));

    assertEquals("{\"message\":\"" + generatedGreeting + "\"}", response);
  }

}
