package com.weni.ecs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SIncidCardSIncidCardFire implements java.io.Serializable{
    
    private Integer recptNum;
    private String incidNum;
    private String callerPhonnum;
    private String callerFlname;
    private String inspFamNm;
    private String dispNeedPersn;
    private Integer afireSize;
    private Integer fireAddReqEquNumb;
    private String fireAdditm;    
}
