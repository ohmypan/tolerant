package com.huahong.tolerant.join.frame.spring;


import com.huahong.tolerant.join.frame.spring.ioc.domain.IocObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext context = new ClassPathXmlApplicationContext();
        context.getApplicationName();
        ((ClassPathXmlApplicationContext) context).refresh();;
        BeanFactory factory = new DefaultListableBeanFactory();
        IocObject iocObject = factory.getBean("iocObject",IocObject.class);
        System.out.println(iocObject.getStr());
        log.debug(iocObject.getStr());
    }
}
