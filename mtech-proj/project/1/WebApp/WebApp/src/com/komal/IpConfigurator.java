package com.komal;

import java.util.ArrayList;
import java.util.HashSet;

public class IpConfigurator
{
	static HashSet<String> blockedIpList = new HashSet<String>();
	public IpConfigurator() 
	{
		populateBlockedIPList();
	}
	static{
		populateBlockedIPList();
	}
	
	public static boolean isIpAllowed(String ip)
	{
		if(blockedIpList.contains(ip))
			return false ;
			
		return true;
	}
	
	public static void populateBlockedIPList()
	{
		blockedIpList.add("192.168.0.3");
	}
}
