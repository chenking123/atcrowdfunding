package com.atguigu.atcrowdfunfing.manager.dao;

import com.atguigu.atcrowdfunfing.bean.Param;
import com.atguigu.atcrowdfunfing.bean.ParamExample;
import java.util.List;

public interface ParamMapper {
    int countByExample(ParamExample example);

    int deleteByExample(ParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Param record);

    int insertSelective(Param record);

    List<Param> selectByExample(ParamExample example);

    Param selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@org.apache.ibatis.annotations.Param("record") Param record, @org.apache.ibatis.annotations.Param("example") ParamExample example);

    int updateByExample(@org.apache.ibatis.annotations.Param("record") Param record, @org.apache.ibatis.annotations.Param("example") ParamExample example);

    int updateByPrimaryKeySelective(Param record);

    int updateByPrimaryKey(Param record);
}