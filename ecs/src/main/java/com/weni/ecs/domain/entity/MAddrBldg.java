/**
 * MAddrBldg Entity 클래스
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

import com.weni.ecs.domain.listener.MAddrBldgListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MAddrBldgListener.class)
@Table(name = "M_ADDR_BLDG") //--주소_건물(Table)
@Schema(description = "주소 건물(Table)")
public class MAddrBldg implements Serializable {
    @Id //  String
    @Column(name = "BLDG_CODE", length = 24, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "건물 코드(pk)", nullable = false)
    private String bldgCode; //--건물_코드(pk)

    @Column(name = "ADDR_ALL_CODE", length = 9, nullable = false)
    @Schema(description = "주소 전체 코드", nullable = false)
    private String addrAllCode; //--주소_전체_코드

    @Column(name = "ROAD_SECT_CODE", length = 7, nullable = false)
    @Schema(description = "도로 구간 코드", nullable = false)
    private String roadSectCode; //--도로_구간_코드

    @Column(name = "MAIN_HS_NUM", length = 4, nullable = true)
    @Schema(description = "본 번지", nullable = true)
    private String mainHsNum; //--본_번지

    @Column(name = "SUB_HS_NUM", length = 4, nullable = true)
    @Schema(description = "부 번지", nullable = true)
    private String subHsNum; //--부_번지

    @Column(name = "BLDG_NM", length = 200, nullable = true)
    @Schema(description = "건물 명", nullable = true)
    private String bldgNm; //--건물_명

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

    @Builder
    public MAddrBldg(String bldgCode, String addrAllCode, String roadSectCode, String mainHsNum, String subHsNum, String bldgNm, Float lgt, Float ltt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.bldgCode = bldgCode;
        this.addrAllCode = addrAllCode;
        this.roadSectCode = roadSectCode;
        this.mainHsNum = mainHsNum;
        this.subHsNum = subHsNum;
        this.bldgNm = bldgNm;
        this.lgt = lgt;
        this.ltt = ltt;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
