/**
 * IDispFacHist Entity Primary Key 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.domain.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
public class IDispFacHistPK implements Serializable {
    private Integer mdtDevId; //--mdt_디바이스_id(pk)
    private Date collTm; //--수집시간(pk)
}
