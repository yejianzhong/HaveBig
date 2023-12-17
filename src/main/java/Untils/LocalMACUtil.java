package Untils;

import java.net.InetAddress;
/**
 * 获取本机MAC地址
 * @author 11579
 *
 */
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Locale;
 
public class LocalMACUtil {
 
    /**
     * 本机MAC地址
     * @return
     * @throws SocketException 
     */
    public static String getLocalMac() throws SocketException{
        InetAddress ip = null;
        StringBuilder sb = new StringBuilder();
        try {
            // 获取本机IP地址对象
            ip = InetAddress.getLocalHost();
            
            // 判断当前主机的网络接口类型为物理网卡
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ip);
            if (networkInterface != null && !networkInterface.isLoopback() && networkInterface.isUp()) {
                byte[] macBytes = networkInterface.getHardwareAddress();
                
                
                for (int i = 0; i < macBytes.length; i++) {
                    sb.append(String.format("%02X%s", macBytes[i], (i < macBytes.length - 1) ? "-" : ""));
                }
                
                //System.out.println("MAC Address: " + sb.toString());
            } else {
                //System.out.println("Failed to get MAC address.");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
		return sb.toString();
    }
}
