package com.example.service;

import javax.inject.Singleton;

@Singleton
public class GreetService {

  public String generateGreet(String name) {
    return "hello " + name;
  }

}
