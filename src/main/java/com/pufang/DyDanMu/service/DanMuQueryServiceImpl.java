package com.pufang.DyDanMu.service;

import com.pufang.DyDanMu.domain.DanMu;
import com.pufang.DyDanMu.domain.DanMuRepository;
import com.pufang.DyDanMu.model.DanMuQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
@Service
public class DanMuQueryServiceImpl implements DanMuQueryService{

    @Autowired
    DanMuRepository danMuRepository;

    @Override
    public Page<DanMu> queryWithCondition(Integer page, Integer size, DanMuQuery danMuQuery) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        Specification<DanMu> danMuSpecification = new Specification<DanMu>(){
            @Override
            public Predicate toPredicate(Root<DanMu> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> list = new ArrayList<Predicate>();
                if (StringUtils.isNotBlank(danMuQuery.getName())){
                    list.add(criteriaBuilder.equal(root.get("nn").as(String.class), danMuQuery.getName()));
                }

                if (danMuQuery.getRoomId() != null){
                    list.add(criteriaBuilder.equal(root.get("rid").as(Integer.class), danMuQuery.getRoomId()));
                }

                if (danMuQuery.getGmtStart() != null){
                    list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("cst").as(Date.class),danMuQuery.getGmtStart()));
                }

                if (danMuQuery.getGmtEnd() != null){
                    list.add(criteriaBuilder.lessThanOrEqualTo(root.get("cst").as(Date.class),danMuQuery.getGmtStart()));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
        return danMuRepository.findAll(danMuSpecification,pageable);
    }
}
