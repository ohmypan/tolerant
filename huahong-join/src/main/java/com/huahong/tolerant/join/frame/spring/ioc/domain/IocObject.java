package com.huahong.tolerant.join.frame.spring.ioc.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * File：IocObject <br>
 * Created on 2020/2/14.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Data
public class IocObject {
    @Value("111")
    private String str;
}
