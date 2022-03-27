package com.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name="COMMON_CODE")
public class CommonCode {
    @Id
    @Column(name = "GROUP_CODE" )
    @Size(max=10)
    private String groupCode;
    @Column(name = "GROUP_NAME" )
    @Size(max=100)
    private String groupName;
    @Column(name = "DELETE_FLAG")
    private Boolean deleteFlag;

    @Builder
    public CommonCode(@Size(max = 10) String groupCode, @Size(max = 100) String groupName, Boolean deleteFlag) {
        this.groupCode = groupCode;
        this.groupName = groupName;
        this.deleteFlag = deleteFlag;
    }

}
