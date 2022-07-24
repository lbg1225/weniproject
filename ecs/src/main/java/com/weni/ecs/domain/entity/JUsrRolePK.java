/**
 * JUsrRole Entity Primary Key 클래스
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
public class JUsrRolePK implements Serializable {
    private String roleCode; //--권한_코드(pk)
    private String roleKnd; //--권한_종류(pk)
    private String usrId; //--사용자_id(pk)
}
