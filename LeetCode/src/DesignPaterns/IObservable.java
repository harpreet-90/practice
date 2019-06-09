package DesignPaterns;

public interface IObservable {
	public void addObserver(IObserver o);
	public void removeObserver(IObserver o);
	public void updateAll();
	public int getTemp();
	public void setTemp(int temp);
}
