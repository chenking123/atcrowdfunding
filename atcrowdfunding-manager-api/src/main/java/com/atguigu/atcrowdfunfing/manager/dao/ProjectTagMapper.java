package com.atguigu.atcrowdfunfing.manager.dao;

import com.atguigu.atcrowdfunfing.bean.ProjectTag;
import com.atguigu.atcrowdfunfing.bean.ProjectTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectTagMapper {
    int countByExample(ProjectTagExample example);

    int deleteByExample(ProjectTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectTag record);

    int insertSelective(ProjectTag record);

    List<ProjectTag> selectByExample(ProjectTagExample example);

    ProjectTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectTag record, @Param("example") ProjectTagExample example);

    int updateByExample(@Param("record") ProjectTag record, @Param("example") ProjectTagExample example);

    int updateByPrimaryKeySelective(ProjectTag record);

    int updateByPrimaryKey(ProjectTag record);
}