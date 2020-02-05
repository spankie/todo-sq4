package com.david.todosq4.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 */
@RestController
public class HomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<String> Home() {
    List<String> ll = new ArrayList<String>();
    ll.add("Home Controller");
    ll.add("Ai Powered");
    return ll;
  }
}