package day20;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class IpEx01 {

	public static void main(String[] args) {
		//xxx.xxx.xxx.xxx : Ipv4
		try {
			InetAddress address = InetAddress.getByName("localhost");
			System.out.println(address);
			
			address = InetAddress.getByName("www.naver.com");
			System.out.println(address);
			
			InetAddress [] list = InetAddress.getAllByName("www.naver.com");
			System.out.println(Arrays.toString(list));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
