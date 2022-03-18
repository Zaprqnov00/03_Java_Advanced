package ClassesExercices.RawData_04;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private int engine;
    private String cargo;
    private List<Double> tires;

    public Car(){
        this.tires = new ArrayList<>();
    }

    public Car(String model, int engine, String cargo, List<Double> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public void add(double tire){
        tires.add(tire);
    }

    public String getModel() {
        return model;
    }

    public int getEngine() {
        return engine;
    }

    public String getCargo() {
        return cargo;
    }

    public List<Double> getTires() {
        return tires;
    }
}
