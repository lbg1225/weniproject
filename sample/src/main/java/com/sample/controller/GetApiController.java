//----------------------------
// 1. GetMapping사용하기
//----------------------------
package com.sample.controller;

import java.util.Map;

import com.sample.dto.UserRequestDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

  // GetMapping사용하기
  // http://localhost:8080/api/get/hello
  @GetMapping(path = "/hello")
  public String Hello() {
    return "get Hello";
  }

  /*----------------------------------------------------------------------------------------------------------------------------
    // Spring boot가 처음이기에 코드에 대해 처음부터 설명을 하며 정리를 해보려한다.
    // 먼저 Class를 생성하는 코드부터 보겠다. 코드의 첫번째 줄인 @RestController은 해당 annotation을 추가해주면서 해당 class는 REST API를 
    // 처리하는 controller로 등록을 한다.
    // 두전째 줄인 @RequestMapping("/api/get")은 URI를 지정해주는 annotation이다.
    // 이렇게 @RestController, @RequestMapping("/api/get")를 통해 GetApiController class는 기본 uri를 http://localhost:8080/api/get 로 
    // 갖으며 REST API를 처리하는 controller로 생성되었다.
    // 
    // 다음으로 Method를 확인해보겠다. Method위에 추가된 @GetMapping(path = "/hello")라는 annotatin은 GET 요청이 path로 들어오면 
    // 해당 method를 mapping시켜주겠다는 의미를 가진다. 위의 코드의 경우는 기본 주소인 http://localhost:8080/api/get에 path인 /hello를 
    // 추가하여 http://localhost:9090/api/get/hello 로 GET request가 들어오면 method가 실행되고 결과인 "get Hello"를 return해주게 된다.
    // 
    // @GetMapping은 기본적으로 괄호안에 ("/hello")라고 입력을 해도 괄호 안의 값을 value값으로 인
    ----------------------------------------------------------------------------------------------------------------------------*/
  // http://localhost:8080/api/get/hi
  @RequestMapping(path = "/hi", method = RequestMethod.GET)
  public String hi() {
    return "get hi";
  }

  /*----------------------------------------------------------------------------------------------------------------------------
    // PathVariable 사용하기
    // 사용자의 이름, 아이디 등 변할 수 있는 정보를 URI에 넣어야 한다면 개발자는 같은 method를 각각의 path를 마다 생성해줘야 할 것이다. 
    // 하지만 이것은 매우 비효율적인 개발 방법이며 이러한 일을 해결해 주는 것이 PathVariable이다. 변화하는 구간에 대해서는 PathVariable을 사용해야한다.
    // PathVariable은 @GetMapping의 Path를 "path-variable/{name}"와 같이 변경될 수 있는 부분을 { }로 지정해주며 사용한다. 
    // { }안에는 변수명을 적으며 method의 parameter에 @PathVariable 변수명을 입력하며 { }에 들어가는 값을 읽어온다.
    ----------------------------------------------------------------------------------------------------------------------------*/
  // http://localhost:8080/api/get/path-variable/이병관
  @GetMapping("path-variable/{name}")
  public String pathVariable(@PathVariable String name) {
    // 일반적으로 34번,35번,38번 line의 변수명(name)이 같아야한다.
    System.out.println("PathVariable : " + name);
    return name;
  }

  /*----------------------------------------------------------------------------------------------------------------------------
    // Query Parameter 사용하기
    // https://www.google.com/search?q=velog.&oq=velog.&aqs=chrome..69i57j0i512l2j0i30j69i60l4.4182j0j4&sourceid=chrome&ie=UTF-8 
    // 다음 주소를 한번 확인해보자.
    // Query parameter는 위의 주소에서 search? 부터의 주소를 의미한다. 즉, 검색을 할 때 여러가지 매개변수들을 의미한다.
    // 
    // 위의 주소를 자세히 보면 중간 중간 and 연산자가 있다.
    // 한번 Query parameter를 &로 나눠서 보도록 하자
    // 
    // search?q=velog.
    // &oq=velog.
    // &aqs=chrome..69i57j0i512l2j0i30j69i60l4.4182j0j4
    // &sourceid=chrome&ie=UTF-8
    // 
    // & 단위로 나눠서 본 URI를 확인해보면 처음에 Search이후 ?로 시작을 하여 key=value의 형식으로 문장이 이어지는 것을 확인할 수 있다.
    // Query parameter는 즉 Key, value값으로 이루어진 연속된 query문으로 이루어진 것을 알 수 있다.
    // 이제 Query parameter를 받는 방법을 알아보도록 하자.
    ----------------------------------------------------------------------------------------------------------------------------*/
  // http://localhost:8080/api/get/query-param01?q=velog.&oq=velog.&aqs=chrome..69i57j0i512l2j0i30j69i60l4.4182j0j4&sourceid=chrome&ie=UTF-8
  @GetMapping(path = "query-param01")
  public String queryParam01(@RequestParam Map<String, String> queryParam) {
    // key=value값으로 데이터를 받기에 Map으로 구현

    StringBuilder sb = new StringBuilder();

    queryParam
      .entrySet()
      .forEach(
        entry -> {
          System.out.println(entry.getKey());
          System.out.println(entry.getValue());
          System.out.println("\n");

          sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        }
      );

    return sb.toString();
  }

  /*----------------------------------------------------------------------------------------------------------------------------
    // 위의 코드는 Map을 활용하여 Key, value값을 받아온 코드이다.
    // 하지만 위의 코드의 경우는 Key값들이 무엇이 있는지 코드상으로 명확하게 알 수가 없다.
    // 아래와 같이 @RequestParam을 여러번 사용하여 Key값을 지정하고 값을 받아오면 
    // Query parameter에서 사용하는 key값들을 미리 알고 지정할 수 있다.
     ----------------------------------------------------------------------------------------------------------------------------*/
  // http://localhost:8080/api/get/query-param02?name=lbg&email=lbg@email.com&age=18
  public String queryParam02(
    @RequestParam String name,
    @RequestParam String email,
    @RequestParam int age
  ) {
    System.out.println(name);
    System.out.println(email);
    System.out.println(age);

    return name + "\n" + email + "\n" + age;
  }

  /*----------------------------------------------------------------------------------------------------------------------------
    // Request DTO(객체)를 미리 만들어 사용하는 방법은 이전 방식과 다르게 @RequestParam을 붙이지 않는다.
    // 코드의 동작 원리는 다음과 같다. Spring boot에서는 parameter로 객체가 들어오면 
    // "?user=steve&email=steve@gmail.com&age=30"와 같은 query parameter에 있는 객체들을 spring boot에서 
    // 판단을 하고 key에 위치한 값들을 객체의 변수의 이름과 매칭을 해주며 작동을 한다.
    // 이전 방식과 다르게 @RequestParam을 붙이지 않는다.
    // Spring boot에서는 parameter로 객체가 들어오면
    // "?user=steve&email=steve@gmail.com&age=30"와 같은
    // query parameter에 있는 객체들을 spring boot에서 판단한다.
    // 그리고 key에 위치한 값들을 객체의 변수의 이름과 매칭을 해준다.
    // 마지막 방법은 객체를 미리 정의하고 사용하는 방법으로 현재 사람들이 가장 많이 사용하는 방법이다.
    ----------------------------------------------------------------------------------------------------------------------------*/
  // http://localhost:8080/api/get/query-param03?name=lbg&email=lbg@email.com&age=18
  @GetMapping(path = "query-param03")
  public String queryParam03(UserRequestDto userRequest) {
    System.out.println(userRequest.getName());
    System.out.println(userRequest.getEmail());
    System.out.println(userRequest.getAge());

    return userRequest.toString();
  }
}
