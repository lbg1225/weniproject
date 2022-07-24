/**
 * MBldgFileInfo Entity Primary Key 클래스
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
public class MBldgFileInfoPK implements Serializable {
    private Integer dtlSeqNum; //--상세_순번(pk)
    private String bldgCode; //--건물_코드(pk)
}
