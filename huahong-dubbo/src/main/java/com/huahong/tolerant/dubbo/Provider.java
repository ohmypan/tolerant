package com.huahong.tolerant.dubbo;

/**
 * File：Provider <br>
 * Created on 2020/4/8.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class Provider {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

    public static void main(String[] args) throws Exception {

        System.out.println( System.getSecurityManager().getThreadGroup().activeCount());
//        ServiceConfig<DubboService> service = new ServiceConfig<>();
//        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
//        service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
//        service.setInterface(DubboService.class);
//        service.setRef(new DubboServiceImpl());
//        service.export();
//
//        System.out.println("dubbo service started");
//        new CountDownLatch(1).await();
    }
}
