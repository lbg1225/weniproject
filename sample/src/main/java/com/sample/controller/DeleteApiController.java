/*----------------------------------------------------------------------------------------------------------------------------
4. DELETE API사용하기
  - DELETE API의 특징
    리소스를 삭제하는 작업을 한다.
    CRUD에서 D에 해당한다.
    하나의 리소스에 대해 같은 작업을 반복하여도 리소스의 결과는 삭제되었다는 상태로 동일하기에 멱등하다.
    리소스를 삭제하는 작업을 하기에 안정성은 없다.
    Path Variable을 사용가능하다.
    Query Parameter도 사용가능하다.
  - 사용되는 Annotation의 종류
    @RestController
    해당 annotation을 추가해주면 해당 class는 REST API를 처리하는 controller로 등록이 된다.
    @RequestMapping(path)
    리소스를 설정하는 코드이며 괄호안에 입력하는 값에 따라 URI가 localhost:8080/path로 설정된다.
    @PathVariable
    변화하는 구간에 사용하는 annotation이며 URL path를 parsing해준다.
    @RequestParam
    URL에 Query문을 추가할 때 parameter를 parshing해준다.
----------------------------------------------------------------------------------------------------------------------------*/
package com.sample.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// DELETE API는 GET API와 같이 @RequestParam을 사용하여 parameter를 받고 해당 리소스를 삭제하는 작업을 한다.
public class DeleteApiController {

  @DeleteMapping("/delete/{userId}")
  public void delete(
    @PathVariable String userId,
    @RequestParam String account
  ) {
    System.out.println(userId);
    System.out.println(account);
  }
}
