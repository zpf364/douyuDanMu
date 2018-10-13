package com.pufang.DyDanMu.service;

import com.pufang.DyDanMu.domain.DanMu;
import com.pufang.DyDanMu.model.DanMuQuery;
import org.springframework.data.domain.Page;

/**
 * @Author pufang.zpf
 * @Date 2018/10/13
 **/
public interface DanMuQueryService {

    Page<DanMu> queryWithCondition(Integer page, Integer size, DanMuQuery danMuQuery);
}
