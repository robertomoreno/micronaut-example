package com.example.controller;

import com.example.service.GreetService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.AllArgsConstructor;
import lombok.Value;

@Controller("/greet")
@AllArgsConstructor
public class GreetController {

  private GreetService service;

  @Get("{name}")
  public GreeterDto greet(String name) {
    return new GreeterDto(service.generateGreet(name));
  }

  @Value
  public static class GreeterDto {
    String message;
  }
}
