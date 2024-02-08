package F9.NB27;

public class Car implements Comparable<Car> {
    private String model;
    private int year, mile;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
        this.mile = mile;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMile() {
        return mile;
    }

    @Override
    public int compareTo(Car o) {
        return this.model.compareTo(o.model);
    }

    @Override
    public String toString() {
        return this.model + " " + this.year;
    }
}
