package com.sample.domain;

import java.io.Serializable;
import lombok.Data;

@Data
class CommonCodeDetailPK implements Serializable {
    private String code;
    private String groupCode;
}
