//----------------------------
// 1. POST API사용하기
//    - POST API의 특징
//      리소스의 생성 및 추가하는 작업을 해주는 API이다.
//      CRUD에서 C에 해당한다.
//      POST Request를 반복한다면 데이터들은 계속 추가될 것이고 서버는 매번 다른 응답을 나타낼 것이다.
//      이때 응답이 같을 수도 있지만 응답이 같더라도 서로 다른 데이터기에 POST API는 멱등하지 않다.
//      또한 GET은 데이터를 읽어오기만 하여 안전성이 있었지만 POST의 경우는 데이터를 추가하며 조작하기에 안전성은 없다.
//      Path Variable을 사용가능하다.
//      Data Body를 사용 가능하다.
//
//    - 사용되는 Annotation의 종류
//      @RestController
//      해당 annotation을 추가해주면 해당 class는 REST API를 처리하는 controller로 등록이 된다.
//      @RequestMapping(path)
//      리소스를 설정하는 코드이며 괄호안에 입력하는 값에 따라 URI가 localhost:8080/path로 설정된다.
//      @PutMapping(path)
//      POST API를 해당 URI로 mapping시켜준다.
//      @RequestBody
//      Request body부분을 Parsing해준다.
//      @PathVariable
//      변화하는 구간에 사용하는 annotation이며 URL path를 parsing해준다.
//      @JsonProperty
//      지정한 변수에 대해 Snake case와 Camel case의 변수를 mapping해준다.
//      @JsonNaming
//      해당 Class 내에 있는 모든 변수에 대해 Snake case와 Camel case의 변수를 mapping해준다.
//----------------------------
package com.sample.controller;

import java.util.Map;

import com.sample.dto.PostRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

  /*----------------------------------------------------------------------------------------------------------------------------
    // POST API도 GET API과 같이 parameter앞에 무언가를 붙여줘야한다. 
    // Get은 데이터를 읽어오기 위해 client에서 읽어오고자 하는 data의 parameter를 보내고 Server는 그것을 받기 위해 
    // @RequestParam을 붙였다면 POST는 데이터를 생성하고 추가하기 위해 아래 사진과 같이 Json 또는 XML타입의 데이터를 
    // Client에서 보내기 때문에 Post는 Data block을 받기 위해 @RequestBody를 붙여준다.
    ----------------------------------------------------------------------------------------------------------------------------*/
  @PostMapping("/post")
  public void post(@RequestBody Map<String, Object> requestData) {
    requestData.forEach(
      (key, value) -> {
        System.out.println("key : " + key);
        System.out.println("value : " + value);
      }
    );
  }

  @PostMapping("/post1")
  public void post1(@RequestBody PostRequestDto requestData) {
    // get과 다르게 객체를 사용하여 받아와도 RequestBody를 입력해줘야한다.
    System.out.println(requestData);
  }
}
