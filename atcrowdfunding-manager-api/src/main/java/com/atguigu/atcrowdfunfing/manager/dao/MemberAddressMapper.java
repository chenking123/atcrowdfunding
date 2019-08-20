package com.atguigu.atcrowdfunfing.manager.dao;

import com.atguigu.atcrowdfunfing.bean.MemberAddress;
import com.atguigu.atcrowdfunfing.bean.MemberAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberAddressMapper {
    int countByExample(MemberAddressExample example);

    int deleteByExample(MemberAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberAddress record);

    int insertSelective(MemberAddress record);

    List<MemberAddress> selectByExample(MemberAddressExample example);

    MemberAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberAddress record, @Param("example") MemberAddressExample example);

    int updateByExample(@Param("record") MemberAddress record, @Param("example") MemberAddressExample example);

    int updateByPrimaryKeySelective(MemberAddress record);

    int updateByPrimaryKey(MemberAddress record);
}