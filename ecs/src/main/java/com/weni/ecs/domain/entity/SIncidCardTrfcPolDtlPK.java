/**
 * SIncidCardTrfcPolDtl Entity Primary Key 클래스
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
public class SIncidCardTrfcPolDtlPK implements Serializable {
    private Integer recptNum; //--접수_번호(pk)
    private String dtlDivCode; //--건물_구분_코드(pk)
    private Integer dtlSeqNum; //--상세_순번(pk)
}
