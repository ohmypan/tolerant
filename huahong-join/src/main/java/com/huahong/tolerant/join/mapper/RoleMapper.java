package com.huahong.tolerant.join.mapper;

import com.huahong.tolerant.join.domain.mybatis.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * File：RoleMapper <br>
 * Created on 2020/3/8.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Component
public interface RoleMapper {
    Role getRoleById(@Param("id") Long id);
}
