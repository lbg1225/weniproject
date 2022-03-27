package com.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity
@IdClass(CommonCodeDetailPK.class)
public class CommonCodeDetail {
    @Id
    @Column(name = "CODE" )
    @Size(max=10)
    private String code;

    @Id
    @Column(name = "GROUP_CODE" )
    @Size(max=10)
    private String groupCode;

    @Column(name = "CODE_NAME" )
    @Size(max=100)
    private String codeName;

    @Column(name = "DELETE_FLAG")
    private Boolean deleteFlag;

    @Builder
    public CommonCodeDetail(@Size(max = 10) String code, @Size(max = 10) String groupCode, @Size(max = 100) String codeName, Boolean deleteFlag) {
        this.code = code;
        this.groupCode = groupCode;
        this.codeName = codeName;
        this.deleteFlag = deleteFlag;
    }

}
