package javalanguage.net;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class IPUtils {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println(InetAddress.getLocalHost().getHostName());
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		System.out.println(InetAddress.getLoopbackAddress().getHostName());
		System.out.println(InetAddress.getLoopbackAddress().getHostAddress());
		System.out.println("--------------------------------------------------------------");
		System.out.println(getIpV4LoopbackAddress());
		System.out.println(getIpV4LanAddress());
		System.out.println(getIpV4WanAddress());
		System.out.println(IPV4_B_RESERVED_ADDR_PATTERN.matcher("19.38").find());
		System.out.println(IPV4_B_RESERVED_ADDR_PATTERN.matcher("172.30.5.7").find());
		System.out.println(IPV4_B_RESERVED_ADDR_PATTERN.matcher("172.19.38").find());
		System.out.println(IPV4_B_RESERVED_ADDR_PATTERN.matcher("173.19.38").find());
		System.out.println(IPV4_B_RESERVED_ADDR_PATTERN.matcher("172.119.38").find());
		System.out.println(IPV4_B_RESERVED_ADDR_PATTERN.matcher("172.25.38.6.1").find());
	}
	
	public static String getIpV4WanAddress() {
		return getIpAddress(IpVersion.IPV4,IpType.WAN);
	}
	
	public static String getIpV4LanAddress() {
		return getIpAddress(IpVersion.IPV4,IpType.LAN);
	}
	
	public static String getIpV4LoopbackAddress() {
		return getIpAddress(IpVersion.IPV4,IpType.LOOPBACK);
	}
	
    public static final String REGEX_IPV4_B_RESERVED_ADDR = "^172\\.(1[6-9]|2[0-9]|3[0-1])";
    public static final Pattern IPV4_B_RESERVED_ADDR_PATTERN = Pattern.compile(REGEX_IPV4_B_RESERVED_ADDR);  
    
	private static String getIpAddress(IpVersion ipVersion,IpType ipType) {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface interfaces = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = interfaces.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if(ipVersion==IpVersion.IPV4){
						if(inetAddress instanceof Inet4Address){
							if(ipType==IpType.LOOPBACK){
								if (inetAddress.isLoopbackAddress()) {
									return inetAddress.getHostAddress().toString();
								}
							}
							else if(ipType==IpType.LAN){
								String hostAddress = inetAddress.getHostAddress();
								if (hostAddress.startsWith("10.") || hostAddress.startsWith("192.168.") || IPV4_B_RESERVED_ADDR_PATTERN.matcher(hostAddress).find()) {
									return hostAddress.toString();
								}
							}
							else if(ipType==IpType.WAN){
								String hostAddress = inetAddress.getHostAddress();
								if (!inetAddress.isLoopbackAddress() && !hostAddress.startsWith("10.") && !hostAddress.startsWith("192.168.")  && !IPV4_B_RESERVED_ADDR_PATTERN.matcher(hostAddress).find()) {
									return hostAddress.toString();
								}
							}
							else{
								throw new IllegalArgumentException("IpType["+ipType+"] is not recognized.");
							}
						}
					}
					else if(ipVersion==IpVersion.IPV6){
						if(inetAddress instanceof Inet6Address){
							if(ipType==IpType.LOOPBACK){
								if (inetAddress.isLoopbackAddress()) {
									return inetAddress.getHostAddress().toString();
								}
							}
							else if(ipType==IpType.LAN){
								throw new IllegalStateException("IPV6 LAN RULE is not known by me ,hehe.");
							}
							else if(ipType==IpType.WAN){
								return inetAddress.getHostAddress().toString();
							}
							else{
								throw new IllegalArgumentException("IpType["+ipType+"] is not recognized.");
							}
						}
					}
					else{
						throw new IllegalArgumentException("IpVersion["+ipVersion+"] is not recognized.");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static enum IpVersion{
		IPV4,IPV6;
	}

	public static enum IpType{
		LOOPBACK,LAN,WAN;
	}
	
}
