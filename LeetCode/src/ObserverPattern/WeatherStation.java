package ObserverPattern;

import java.util.ArrayList;

public class WeatherStation implements IObservable{

	int temp;
	ArrayList<IObserver> observers =  new ArrayList<IObserver>();
	@Override
	public void add(IObserver o) {
		// TODO Auto-generated method stub
		observers.add(o);
		System.out.println(o.getName()+" is added.");
	}

	@Override
	public void remove(String name) {
		// TODO Auto-generated method stub
		for(int i=0; i<observers.size(); i++)
		{
			if((observers.get(i).getName()).compareTo(name) == 0)
			{
				remove(observers.get(i));
				break;
			}
		}
		
	}
	public void remove(IObserver o) {
		// TODO Auto-generated method stub
		System.out.println(o.getName()+" is removed.");
		observers.remove(o);
	}

	@Override
	public void updateAll() {
		// TODO Auto-generated method stub
		for(int i=0; i<observers.size(); i++)
		{
			observers.get(i).update();
		}
		
//		temp = temp+5;
	}
	public int getTemperature()
	{
		return temp;
	}

	@Override
	public void setTemperature(int temp1) {
		// TODO Auto-generated method stub
		this.temp = temp1;
	}

}
