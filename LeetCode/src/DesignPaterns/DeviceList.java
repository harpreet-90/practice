package DesignPaterns;

import java.util.ArrayList;

public class DeviceList {
	ArrayList<Device> devices = new ArrayList<Device>();
	WeatherObject w ;
	DeviceList(WeatherObject w)
	{
		this.w = w;
	}
	public void add(Device d)
	{
		devices.add(d);
		System.out.println("Device added.");
	}
	public void remove(String name)
	{
		for(int i=0;i<devices.size();i++)
		{
			if(devices.get(i).name.compareTo(name) == 0)
			{
				devices.remove(i);
				System.out.println("Device with name <"+name+" got removed.");
				break;
			}
		}
	}
	public void updateAll() throws InterruptedException
	{
		System.out.println("Printing Temp..");
		for(int i=0;i<devices.size(); i++)
		{
			(devices.get(i)).display();
		} 
	}
}
