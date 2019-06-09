package DesignPaterns;

public class AndroidDisplay implements IDisplayable {

	@Override
	public void display(String name, int temp) {
		System.out.println("Displaying temp in Android Device: <"+name+">" + temp);
	}
	
	
}
