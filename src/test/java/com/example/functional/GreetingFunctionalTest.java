package com.example.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class GreetingFunctionalTest {

  @Inject
  @Client("/greet")
  HttpClient client;

  @Test
  public void testGreeting() {
    String response = client.toBlocking().retrieve(HttpRequest.GET("/world"));
    assertEquals("{\"message\":\"hello world\"}", response);
  }

}
