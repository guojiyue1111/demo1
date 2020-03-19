package com.guojiyue.demo1.dao;

import com.guojiyue.demo1.entity.Kind;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kind record);

    int insertSelective(Kind record);

    Kind selectByPrimaryKey(Integer id);

    List<Kind> selectAll();

    int updateByPrimaryKeySelective(Kind record);

    int updateByPrimaryKey(Kind record);
}