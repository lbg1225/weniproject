/**
 * MIncidType Entity Primary Key 클래스
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
public class MIncidTypePK implements Serializable {
    private String incidtypeBigclssfyCode; //--사건_유형_대분류_코드(pk)
    private String incidtypeMedclssfyCode; //--사건_유형_중분류_코드(pk)
    private String incidtypeSmallclssfyCode; //--사건_유형_소분류_코드(pk)
}
