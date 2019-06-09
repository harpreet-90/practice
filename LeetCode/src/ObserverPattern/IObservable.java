package ObserverPattern;

public interface IObservable {
public void add(IObserver o);
public void remove(String name);
public void updateAll();
public int getTemperature();
public void setTemperature(int temp);
}
