package com.sample.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserRequestDto {

  private String name;
  private String email;
  private int age;

  @Builder
  public UserRequestDto(String name, String email, int age) {
    this.name = name;
    this.email = email;
    this.age = age;
  }
}
