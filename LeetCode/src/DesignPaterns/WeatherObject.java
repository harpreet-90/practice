package DesignPaterns;

import java.util.ArrayList;

public class WeatherObject implements IObservable {
	int temp = 1;
	ArrayList<IObserver> observers = new ArrayList<IObserver>();
	public int getTemp()
	{
		System.out.println("geting temp.");
//		temp++;
		return temp;
	}
	
	public void setTemp(int temp)
	{
		this.temp = temp;
	}

	@Override
	public void addObserver(IObserver o) {
		observers.add(o);
		updateAll();
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
		
	}
	public void removeObserver(String name) {
		int i=0;
		while(i<observers.size())
		{
			if((observers.get(i)).name)
			{
				
			}
		}
		
	}
	@Override
	public void updateAll() {
		for(int i=0; i<observers.size();i++)
		{
			observers.get(i).update(this);
		}
	}
}
