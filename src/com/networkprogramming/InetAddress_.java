package com.networkprogramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 演示InetAddress的使用
 */
public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
//        获取本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DESKTOP-E0N6TOD/192.168.56.1

        //根据指定主机名/域名获取ip地址对象：
        InetAddress byName = InetAddress.getByName("DESKTOP-E0N6TOD");
        //InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

        //获取本机InetAddress对象的主机名：
        String hostName = byName.getHostName();
        System.out.println(hostName);


        //获取本机InetAddress对象的地址
        String hostAddress = byName.getHostAddress();
        System.out.println(hostAddress);

    }
}
