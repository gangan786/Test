package com.meizhuo.computer_network;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;

import java.io.IOException;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.computer_network
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/11/1 20:52
 * @UpdateUser:
 * @UpdateDate: 2018/11/1 20:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Capture {


    public static void main(String[] args) {
        //第一步绑定网络设备
        NetworkInterface[] deviceList = JpcapCaptor.getDeviceList();

        //发现第六个NetworkInterface为无线局域网WALN
        for (NetworkInterface networkInterface : deviceList) {
            System.out.println("网络接口的名字为：" + networkInterface.name
                    + "  |  " + "网络描述为：" + networkInterface.description
                    + "  |  " + "本地链接 IPv6 地址为：" + networkInterface.addresses[0].address);
            System.out.println();
        }

        JpcapCaptor jpcapCaptor = null;
        //数据报最大长度
        int caplen = 1512;
        //是否开启混杂模式
        boolean promiscCheck = true;

        try {
            //针对网卡进行抓包
            // 最后一个参数表示最长等待时间
            //获取jpacapCaptor实例
            jpcapCaptor = JpcapCaptor.openDevice(deviceList[5], caplen, promiscCheck, 50);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //开始抓包


        captureTCP(jpcapCaptor);


    }

    /**
     * 抓取TCP数据包
     *
     * @param jpcapCaptor
     */
    private static void captureTCP(JpcapCaptor jpcapCaptor) {
        while (true) {
            Packet packet = jpcapCaptor.getPacket();
            if (packet instanceof TCPPacket) {
                TCPPacket tcpPacket = (TCPPacket) packet;
                System.out.println("源端口：" + tcpPacket.src_port);
                System.out.println("目的端口：" + tcpPacket.dst_port);
                System.out.println("序号：" + tcpPacket.sequence);
                System.out.println("确认序号：" + tcpPacket.ack_num);
                if (tcpPacket.urg) {
                    System.out.println("URG确认");
                }
                if (tcpPacket.ack) {
                    System.out.println("ACK确认");
                }
                if (tcpPacket.psh) {
                    System.out.println("PSH确认");
                }
                if (tcpPacket.rst) {
                    System.out.println("RST确认");
                }
                if (tcpPacket.syn) {
                    System.out.println("SYN确认");
                }
                if (tcpPacket.fin) {
                    System.out.println("FIN确认");
                }
                System.out.println("窗口值" + tcpPacket.window);
                System.out.println("=======================================================");


            }
        }
    }

    /**
     * 抓取IPV4包
     *
     * @param jpcapCaptor
     */
    private static void captureIPV4(JpcapCaptor jpcapCaptor) {
        int i = 0;
        while (i < 10) {
            Packet packet = jpcapCaptor.getPacket();
            if (packet instanceof IPPacket && ((IPPacket) packet).version == 4) {
                //这里是抓ipv4的包
                i++;
                IPPacket ipPacket = (IPPacket) packet;

                System.out.println("版本IPV4");
                System.out.println("优先权：" + ipPacket.priority);
                System.out.println("区分服务：最大吞吐量：" + ipPacket.t_flag);
                System.out.println("区分服务：最靠的可靠性" + ipPacket.r_flag);
                System.out.println("长度：" + ipPacket.length);
                System.out.println("标识：" + ipPacket.ident);
                System.out.println("DF:Don`t Fragment：" + ipPacket.dont_frag);
                System.out.println("MF:More Fragment：" + ipPacket.more_frag);
                System.out.println("偏移量：" + ipPacket.offset);
                System.out.println("生存时间：" + ipPacket.hop_limit);

                String protocol = "";
                switch (new Integer(ipPacket.protocol)) {
                    case 1:
                        protocol = "ICMP";
                        break;
                    case 2:
                        protocol = "IGMP";
                        break;
                    case 6:
                        protocol = "TCP";
                        break;
                    case 8:
                        protocol = "EGP";
                        break;
                    case 9:
                        protocol = "IGP";
                        break;
                    case 17:
                        protocol = "UDP";
                        break;
                    case 41:
                        protocol = "IPv6";
                        break;
                    case 89:
                        protocol = "OSPF";
                        break;
                    default:
                        break;
                }
                System.out.println("协议：" + protocol);
                System.out.println("源IP " + ipPacket.src_ip.getHostAddress());
                System.out.println("目的IP " + ipPacket.dst_ip.getHostAddress());
                System.out.println("源主机名： " + ipPacket.src_ip);
                System.out.println("目的主机名： " + ipPacket.dst_ip);
                System.out.println("----------------------------------------------");

            }
        }
    }
}
