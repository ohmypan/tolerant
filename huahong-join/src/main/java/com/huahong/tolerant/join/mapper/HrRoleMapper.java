package com.huahong.tolerant.join.mapper;

import com.huahong.tolerant.join.domain.mybatis.HrRole;
import com.huahong.tolerant.join.domain.mybatis.HrRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HrRoleMapper {
    int countByExample(HrRoleExample example);

    int deleteByExample(HrRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    List<HrRole> selectByExample(HrRoleExample example);

    HrRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HrRole record, @Param("example") HrRoleExample example);

    int updateByExample(@Param("record") HrRole record, @Param("example") HrRoleExample example);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);
}