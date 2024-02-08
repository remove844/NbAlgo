package F9.NB27;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "bilar.txt";
        Car[] lines = FileHandler.readFile(fileName);
        for(Car line : lines){
            System.out.println(line);
        }

        String fileName2 = "bilar2.txt";
        FileHandler.writeArrayToFile(fileName2);

        String fileName3 = "bilar3.txt";
        FileHandler.writeArrayToFileSortedYear(fileName3);



    }
}