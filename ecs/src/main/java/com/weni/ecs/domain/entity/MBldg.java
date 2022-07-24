/**
 * MBldg Entity 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.MBldgListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MBldgListener.class)
@Table(name = "M_BLDG") //--건물(Table)
@Schema(description = "건물(Table)")
public class MBldg implements Serializable {
    @Id //  String
    @Column(name = "BLDG_CODE", length = 24, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "건물 코드(pk)", nullable = false)
    private String bldgCode; //--건물_코드(pk)

    @Column(name = "BLDG_NM", length = 200, nullable = true)
    @Schema(description = "건물 명", nullable = true)
    private String bldgNm; //--건물_명

    @Column(name = "ADDR_STATE", length = 100, nullable = true)
    @Schema(description = "주소 주", nullable = true)
    private String addrState; //--주소_주

    @Column(name = "ADDR_FCITY", length = 100, nullable = true)
    @Schema(description = "주소 도시", nullable = true)
    private String addrFcity; //--주소_도시

    @Column(name = "ADDR_WARD", length = 100, nullable = true)
    @Schema(description = "주소 군", nullable = true)
    private String addrWard; //--주소_군

    @Column(name = "ADDR_DISTRICT", length = 100, nullable = true)
    @Schema(description = "주소 동", nullable = true)
    private String addrDistrict; //--주소_동

    @Column(name = "ADDR_DIST", length = 100, nullable = true)
    @Schema(description = "주소 거리", nullable = true)
    private String addrDist; //--주소_거리

    @Column(name = "ADDR_HS_NUM", length = 100, nullable = true)
    @Schema(description = "주소 번지", nullable = true)
    private String addrHsNum; //--주소_번지

    @Column(name = "ADDR_APT_DISTRICT", length = 30, nullable = true)
    @Schema(description = "주소 아파트 동", nullable = true)
    private String addrAptDistrict; //--주소_아파트_동

    @Column(name = "LGT", nullable = true)
    @Schema(description = "경도", nullable = true)
    private Float lgt; //--경도

    @Column(name = "LTT", nullable = true)
    @Schema(description = "위도", nullable = true)
    private Float ltt; //--위도

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    @Schema(description = "최초 등록자 id", nullable = true)
    private String fstRegpersnId; //--최초_등록자_id

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    @Schema(description = "최종 수정자 id", nullable = true)
    private String finalUptpersnId; //--최종_수정자_id

    @Column(name = "FST_REG_TM", nullable = true)
    @Schema(description = "최초 등록 시간", nullable = true)
    private Date fstRegTm; //--최초_등록_시간

    @Column(name = "FINAL_UPT_TM", nullable = true)
    @Schema(description = "최종 수정 시간", nullable = true)
    private Date finalUptTm; //--최종_수정_시간

    @Column(name = "BLDG_GB_CODE", length = 20, nullable = true)
    @Schema(description = "건물 구분 코드", nullable = true)
    private String bldgGbCode; //--건물_구분_코드

    @Builder
    public MBldg(String bldgCode, String bldgNm, String addrState, String addrFcity, String addrWard, String addrDistrict, String addrDist, String addrHsNum, String addrAptDistrict, Float lgt, Float ltt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String bldgGbCode) {
        this.bldgCode = bldgCode;
        this.bldgNm = bldgNm;
        this.addrState = addrState;
        this.addrFcity = addrFcity;
        this.addrWard = addrWard;
        this.addrDistrict = addrDistrict;
        this.addrDist = addrDist;
        this.addrHsNum = addrHsNum;
        this.addrAptDistrict = addrAptDistrict;
        this.lgt = lgt;
        this.ltt = ltt;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.bldgGbCode = bldgGbCode;
    }
}
