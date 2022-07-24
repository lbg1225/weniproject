/**
 * JUsrGrpMnu Entity Primary Key 클래스
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
public class JUsrGrpMnuPK implements Serializable {
    private String usrGrpId; //--사용자_그룹_id(pk)
    private String mnuId; //--메뉴_id(pk)
}
