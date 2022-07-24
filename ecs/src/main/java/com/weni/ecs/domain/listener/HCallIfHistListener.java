/**
 * HCallIfHist Entity Listener 클래스
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

import com.weni.ecs.domain.entity.HCallIfHist;

@Slf4j
public class HCallIfHistListener {

	//----------------------------------------------------
    // Load/Persist/Update/Remove(조회/신규/수정/삭제)
    // Entity Pre/Post(이전/이후) 처리에 대한 정의(PreLoad는 없음)
    // * DB의 Trigger와 비슷한 JPA기능
    //----------------------------------------------------
    @PostLoad
    public void onPostLoad(HCallIfHist postData) {
        log.info("onPostLoad : Select후 호출({})" , postData.toString() );
    }

    @PrePersist
    public void onPrePersist(HCallIfHist preData) {
        log.info("onPrePersist : Insert전 호출({})" , preData.toString() );
    }

    @PostPersist
    public void onPostPersist(HCallIfHist postData) {
        log.info("onPrePersist : Insert후 호출({})" , postData.toString() );
    }

    @PreUpdate
    public void onPreUpdate(HCallIfHist preData) {
        log.info("onPreUpdate : Update전 호출({})" , preData.toString() );
    }

    @PostUpdate
    public void onPostUpdate(HCallIfHist postData) {
        log.info("onPostUpdate : Update후 호출({})" , postData.toString() );
    }

    @PreRemove
    public void onPreRemove(HCallIfHist preData) {
        log.info("onPreRemove  : Delete전 호출({})" , preData.toString() );
    }

    @PostRemove
    public void onPostRemove(HCallIfHist postData) {
        log.info("onPostRemove : Delete후 호출({})" , postData.toString() );
    }
}
