package com.pufang.DyDanMu.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
public interface DanMuRepository extends CrudRepository<DanMu,Long>, JpaSpecificationExecutor<DanMu> {

    List<DanMu> findByRid(int rid);
    List<DanMu> findByRidAndNn(int rid,String nn);
}
