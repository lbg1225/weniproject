/**
 * HNotfcRecvHist Entity Primary Key 클래스
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
public class HNotfcRecvHistPK implements Serializable {
    private Integer mkcallSeqNum; //--발신_순번(pk)
    private String usrId; //--사용자_id(pk)
}
