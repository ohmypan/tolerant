package com.huahong.tolerant.join;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author ohmypan
 */
@SpringBootApplication
public class HuahongJoinApplication {


    public static void main(String[] args) {

//        runCmd("cmd /c start D:\\code\\tolerant\\huahong-join\\src\\main\\java\\com\\huahong" +
//                "\\tolerant\\join\\bat\\startKafka.bat");
//        runCmd("cmd /c start D:\\code\\tolerant\\huahong-join\\src\\main\\java\\com\\huahong" +
//                "\\tolerant\\join\\bat\\startZookeeper.bat");
        SpringApplication.run(HuahongJoinApplication.class, args);
    }

    public static void runCmd(String strCmd) {
        //Runtime.getRuntime()返回当前应用程序的Runtime对象
        Runtime rt = Runtime.getRuntime();
        //Process可以控制该子进程的执行或获取该子进程的信息。
        Process ps = null;
        try {
            //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            ps = rt.exec(strCmd);
            //等待子进程完成再往下执行。
            ps.waitFor();
        } catch (IOException | InterruptedException e1) {
            e1.printStackTrace();
        } finally {
            if(ps != null) {
                //销毁子进程
                ps.destroy();
            }
            ps = null;
        }
        //接收执行完毕的返回值
        int i = ps == null ?0:ps.exitValue();
        if (i == 0) {
            System.out.println("执行完成.");
        } else {
            System.out.println("执行失败.");
        }


    }
}
