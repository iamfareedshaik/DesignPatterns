import java.util.*;
class WeatherStation{
    private List<Observers> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;


    public void addObserver(Observers observer){
        observers.add(observer);
    }

    public void removeObserver(Observers observer){
        observers.remove(observer);
    }

    public void measurementChange(){
        notifyObserver();
    }
    public void setMeasurement(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChange();
    }
    private void notifyObserver(){
        for(Observers observer: observers){
            observer.update(temperature, humidity, pressure);
        }
    }
}

interface Observers{
    void update(float temperature, float humidity, float pressure);
}

class CurrentCondition implements Observers{
    private float temperature;
    private float humidity;
    private float pressure;
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void display(){
        System.out.print("temperature:"+ temperature + "humidity:" + humidity + "pressure:" + pressure);
    }
}

class Observer{
    public static void main(String args[]){
        WeatherStation obs  = new WeatherStation();
        CurrentCondition curr = new CurrentCondition();
        CurrentCondition curr1 = new CurrentCondition();
        obs.addObserver(curr);
        obs.addObserver(curr1);
        obs.setMeasurement(80, 65, 30.4f);
    }   
}