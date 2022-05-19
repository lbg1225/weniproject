package com.weni.ecs.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.weni.ecs.DefaultRes;
import com.weni.ecs.ResponseMessage;
import com.weni.ecs.StatusCode;
import com.weni.ecs.mapper.SIncidCardSIncidCardFireMapper;
import com.weni.ecs.dto.SIncidCardSIncidCardFire;

@Service
public class SampleService {
    private  SIncidCardSIncidCardFireMapper sIncidCardSIncidCardFireMapper;

    public SampleService(SIncidCardSIncidCardFireMapper sIncidCardSIncidCardFireMapper) {
        this.sIncidCardSIncidCardFireMapper = sIncidCardSIncidCardFireMapper;
    }

    public DefaultRes<List>  getByIncidNum(SIncidCardSIncidCardFire sIncidCardSIncidCardFire) {
        final List<SIncidCardSIncidCardFire> sIncidCardSIncidCardFireList = sIncidCardSIncidCardFireMapper.getByIncidNum(sIncidCardSIncidCardFire);

        if (sIncidCardSIncidCardFireList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.FOUND_SUCESS, sIncidCardSIncidCardFireList);
    }
}
