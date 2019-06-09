package ObserverPattern;

import ObserverPattern.IObservable;

public class PhoneDisplay implements IObserver,IDisplay {

	IObservable w;
	String name;
	
	public PhoneDisplay(String name, IObservable w2) {
		this.w = w2;
		this.name = name;
	}
	@Override
	public void update() {
		display(w.getTemperature(), name);
	}

	@Override
	public void display(int temp, String oName) 
	{
		System.out.println(oName+" is displayin temp: "+temp);
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
