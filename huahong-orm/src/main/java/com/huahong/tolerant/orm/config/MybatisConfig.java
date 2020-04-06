package com.huahong.tolerant.orm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * File：MybatisConfig <br>
 * Created on 2020/4/6.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.huahong.tolerant.orm.dao")
public class MybatisConfig {
}
