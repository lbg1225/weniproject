package com.weni.ecs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import lombok.Data;
import com.weni.ecs.dto.SIncidCardSIncidCardFire;

@Mapper
public interface  SIncidCardSIncidCardFireMapper {
    List<SIncidCardSIncidCardFire>getByIncidNum(SIncidCardSIncidCardFire param);
}
