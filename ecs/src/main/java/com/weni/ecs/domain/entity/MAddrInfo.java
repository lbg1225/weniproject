/**
 * MAddrInfo Entity 클래스
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

import com.weni.ecs.domain.listener.MAddrInfoListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MAddrInfoListener.class)
@Table(name = "M_ADDR_INFO") //--주소_정보(Table)
@Schema(description = "주소 정보(Table)")
public class MAddrInfo implements Serializable {
    @Id //  String
    @Column(name = "ADDR_ALL_CODE", length = 9, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "주소 전체 코드(pk)", nullable = false)
    private String addrAllCode; //--주소_전체_코드(pk)

    @Column(name = "LVL", length = 1, nullable = true)
    @Schema(description = "레벨", nullable = true)
    private String lvl; //--레벨

    @Column(name = "ADDR_STATE_CODE", length = 2, nullable = true)
    @Schema(description = "주소 주 코드", nullable = true)
    private String addrStateCode; //--주소_주_코드

    @Column(name = "ADDR_CITY_CODE", length = 3, nullable = true)
    @Schema(description = "주소 시 코드", nullable = true)
    private String addrCityCode; //--주소_시_코드

    @Column(name = "ADDR_DISTRICT_CODE", length = 4, nullable = true)
    @Schema(description = "주소 동 코드", nullable = true)
    private String addrDistrictCode; //--주소_동_코드

    @Column(name = "ADDR_ALL_NM", length = 500, nullable = true)
    @Schema(description = "주소 전체 명", nullable = true)
    private String addrAllNm; //--주소_전체_명

    @Column(name = "ADDR_STATE_NM", length = 100, nullable = true)
    @Schema(description = "주소 주 명", nullable = true)
    private String addrStateNm; //--주소_주_명

    @Column(name = "ADDR_CITY_NM", length = 100, nullable = true)
    @Schema(description = "주소 시 명", nullable = true)
    private String addrCityNm; //--주소_시_명

    @Column(name = "ADDR_DISTRICT_NM", length = 100, nullable = true)
    @Schema(description = "주소 동 명", nullable = true)
    private String addrDistrictNm; //--주소_동_명

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

    @Builder
    public MAddrInfo(String addrAllCode, String lvl, String addrStateCode, String addrCityCode, String addrDistrictCode, String addrAllNm, String addrStateNm, String addrCityNm, String addrDistrictNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.addrAllCode = addrAllCode;
        this.lvl = lvl;
        this.addrStateCode = addrStateCode;
        this.addrCityCode = addrCityCode;
        this.addrDistrictCode = addrDistrictCode;
        this.addrAllNm = addrAllNm;
        this.addrStateNm = addrStateNm;
        this.addrCityNm = addrCityNm;
        this.addrDistrictNm = addrDistrictNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
