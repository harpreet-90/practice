package DesignPaterns;

public class MI extends Device {
	String name;
	public MI(IObservable w, String name) {
		super( name,  w);
		this.name = name;
		super.d = new AndroidDisplay();
	}

	public void display()
	{
		System.out.println("MI Temp " + super.w.getTemp());
	}
	public String getName()
	{
		return super.name;
	}
}
