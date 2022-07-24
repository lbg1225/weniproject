//----------------------------
// 1. PUT API 사용하기
//    - PUT API 특징
//      리소스를 갱신하고 생성하는 작업을 한다.
//      CRUD에서 C,U작업을 한다.
//      POST와 다르게 같은 명령을 내렸을 때 해당 데이터가 없다면 새로 생성하고 해당 데이터가 있으면 업데이트를 하기에 PUT요청이 여러번 실행되어도 해당 데이터는 같은 상태이기에 멱등하다.
//      POST와 동일하게 데이터 조작을 하기에 안정성은 없다.
//      Path Variable을 사용가능하다.
//      Data Body를 사용 가능하다.
//
//    - 사용되는 Annotation의 종류
//      @RestController
//      해당 annotation을 추가해주면 해당 class는 REST API를 처리하는 controller로 등록이 된다.
//      @RequestMapping(path)
//      리소스를 설정하는 코드이며 괄호안에 입력하는 값에 따라 URI가 localhost:8080/path로 설정된다.
//      @PutMapping(path)
//      PUT API를 해당 URI로 mapping시켜준다.
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

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.PostRequestDto;

@RestController
@RequestMapping("/api")
public class PutApiController {

  /*----------------------------------------------------------------------------------------------------------------------------
    // PUT API는 POST API와 사용법이 거의 동일하다.
    // 사용법이 동일하기에 POST API는 간단한 예시자료만 올리도록 하겠다.
    // Annotation에 대한 자세한 사용법을 알고 싶다면 GET API, POST API 포스트를 참조하길 바란다.
    // 
    // 반환값 없이 받기만 하는 코드
    ----------------------------------------------------------------------------------------------------------------------------*/
  @PutMapping("/put1")
  public void put1(@RequestBody PostRequestDto requestDto) {
    System.out.println(requestDto);
  }

  /*----------------------------------------------------------------------------------------------------------------------------
    // 반환값으로 받은 데이터를 다시 json으로 보내는 코드
    ----------------------------------------------------------------------------------------------------------------------------*/
  @PutMapping("/put2")
  public PostRequestDto put2(@RequestBody PostRequestDto requestDto) {
    System.out.println(requestDto);
    return requestDto;
  }

  /*----------------------------------------------------------------------------------------------------------------------------
    // pathVariable를 추가한 예시
    ----------------------------------------------------------------------------------------------------------------------------*/
  @PutMapping("/put3/{userId}")
  public PostRequestDto put3(
    @RequestBody PostRequestDto requestDto,
    @PathVariable(name = "userId") Long id
  ) {
    System.out.println(requestDto);
    return requestDto;
  }
}
