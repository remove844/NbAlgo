package F9.NB27;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;

public class FileHandler {
    private static Car[] cars = new Car[0];

    public static Car[] readFile(String filename){
        File file = new File(filename);
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String model = scanner.next();
                int year = scanner.nextInt();
                cars = addElementToArray(cars, new Car(model, year));
            }
        }catch (FileNotFoundException e){
            System.out.println("Filen finns inte: " + filename);
        }

        SelectionSort(new CompareCarByModel());
        return cars;
    }

    public static Car[] addElementToArray(Car[] arr, Car element){
        int size = cars.length;
        Car[] newArray = new Car[size + 1];
        System.arraycopy(cars, 0 , newArray, 0, size);
        newArray[size] = element;
        return newArray;
    }

    public static void writeArrayToFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        try(PrintWriter writer = new PrintWriter(file)){
            for(Car element : cars){
                writer.println(element.getModel() + " " + element.getYear());
            }
        }catch (FileNotFoundException e){
            System.out.println("Filen finns inte: " + fileName);
        }
    }

    public static void writeArrayToFileSortedYear(String fileName) throws FileNotFoundException {
        SelectionSort(new CompareCar());

        File file = new File(fileName);
        try(PrintWriter writer = new PrintWriter(file)){
            for(Car car : cars){
                writer.println(car.getModel() + " " + car.getYear());
            }
        }catch (FileNotFoundException e){
            System.out.println("Filen finns inte: " + fileName);
        }
    }

    public static void SelectionSort(Comparator<Car> comp){

        int n = cars.length;
        for(int i = 0; i < n-1; i++){
            int minIndex = i;

            for (int j = i+1; j < n; j++){
                if(comp.compare(cars[j], cars[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            Car temp = cars[minIndex];
            cars[minIndex] = cars[i];
            cars[i] = temp;
        }
    }
}
