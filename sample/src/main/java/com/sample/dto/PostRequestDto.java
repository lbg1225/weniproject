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
// @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostRequestDto {

  private String account;
  private String email;
  private String address;
  private String password;
  // @JsonProperty("phone_number")
  private String phoneNumber;

  @Builder
  public PostRequestDto(
    String account,
    String email,
    String address,
    String password,
    String phoneNumber
  ) {
    this.account = account;
    this.email = email;
    this.address = address;
    this.password = password;
    this.phoneNumber = phoneNumber;
  }
}
