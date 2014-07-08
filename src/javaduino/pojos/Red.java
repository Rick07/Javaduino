package javaduino.pojos;

import java.net.NetworkInterface;
import java.net.SocketException;

public class Red{
 
   public String obtenerDireccionMac(){
       
       String macAddress = "";
	try {
		NetworkInterface network = NetworkInterface.getByName("eth0");
 
		byte[] mac = network.getHardwareAddress();
 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));		
		}
		macAddress = sb.toString();
 
	} catch (SocketException e) {
            System.out.println(e.getMessage());
	}
        return macAddress;
   } 
}