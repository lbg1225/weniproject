package com.sample.controller;

import java.util.ArrayList;
import java.util.List;

import com.sample.domain.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

  @RequestMapping("/")
  public String indexjsp() {
    return "index"; // 실제 호출 될 /WEB-INF/views/index.jsp
  }

  /**
   * @ResponseBody 때문에 html형식으로 들어감
   * */
  @RequestMapping("/hello") // localhost:8081/hello
  public @ResponseBody String root() throws Exception {
    return "Hello Gradle1!!";
  }
  

  /**
   * test1은 application.properties에 있는 prefix와 suffix때문에 앞뒤로 "/WEB-INF/views/"와 ".jsp"가 붙게됨.
   * 이를 spring의 관점에서 보면
   *
   * spring.mvc.view.prefix=/WEB-INF/views/
   *            +
   * 메소드 리턴값 = test1
   *            +
   * spring.mvc.view.suffix=.jsp
   *
   * 따라서 생성되는 경로는 /WEB-INF/views/test1.jsp임.
   * 이는 앞선 설명이었던 @ResponseBody 가 없어서 가능한 일임.
   *
   * */
  @RequestMapping("/test") // localhost:8081/test2
  public String test2() {
    return "sub/test"; // 실제 호출 될 /WEB-INF/views/sub/test2.jsp
  }
}
