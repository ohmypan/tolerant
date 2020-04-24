package com.huahong.tolerant.join.frame.spring;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * File：SpringBean <br>
 * Created on 2020/2/14.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@SpringBootTest
public class SpringBean {
    private final static Log log = LogFactory.getLog(SpringBean.class);
    /**
     * 获取
     */
    @Test
    public void getSpringBean(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("/config/spring.xml");
//        IocObject iocObject = context.getBean(IocObject.class);
//        System.out.println(iocObject.getStr());
//        log.debug(iocObject.getStr());
    }
}
