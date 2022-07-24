/**
 * JJurisAgcy Entity Primary Key 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.domain.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
public class JJurisAgcyPK implements Serializable {
    private String jurisCode; //--관할_코드(pk)
    private String jurisMngCode; //--관할_관리_코드(pk)
}
