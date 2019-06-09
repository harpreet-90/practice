package DesignPaterns;

public class Device implements IObserver{
	IObservable w;
	IDisplayable d;
	public String name;
	
	public Device(String n, IObservable w)
	{
		this.name = n;
		this.w = w;
	}
	
	public void display()
	{
		System.out.println("display nothing: its parent class.");
	}

	@Override
	public void update(IObservable obv) {
		w = obv;
		display();
	}
}
