/**
 * MLabl Entity Listener 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.domain.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;

import com.weni.ecs.domain.entity.MLabl;

@Slf4j
public class MLablListener {

	//----------------------------------------------------
    // Load/Persist/Update/Remove(조회/신규/수정/삭제)
    // Entity Pre/Post(이전/이후) 처리에 대한 정의(PreLoad는 없음)
    // * DB의 Trigger와 비슷한 JPA기능
    //----------------------------------------------------
    @PostLoad
    public void onPostLoad(MLabl postData) {
        log.info("onPostLoad : Select후 호출({})" , postData.toString() );
    }

    @PrePersist
    public void onPrePersist(MLabl preData) {
        log.info("onPrePersist : Insert전 호출({})" , preData.toString() );
    }

    @PostPersist
    public void onPostPersist(MLabl postData) {
        log.info("onPrePersist : Insert후 호출({})" , postData.toString() );
    }

    @PreUpdate
    public void onPreUpdate(MLabl preData) {
        log.info("onPreUpdate : Update전 호출({})" , preData.toString() );
    }

    @PostUpdate
    public void onPostUpdate(MLabl postData) {
        log.info("onPostUpdate : Update후 호출({})" , postData.toString() );
    }

    @PreRemove
    public void onPreRemove(MLabl preData) {
        log.info("onPreRemove  : Delete전 호출({})" , preData.toString() );
    }

    @PostRemove
    public void onPostRemove(MLabl postData) {
        log.info("onPostRemove : Delete후 호출({})" , postData.toString() );
    }
}
