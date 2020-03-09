package com.huahong.tolerant.join.domain.mybatis;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * File：Role <br>
 * Created on 2020/3/8.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Data
@NoArgsConstructor
@ToString
public class Role {
    private Long id;
    private String name;
    private String nameZh;
}
