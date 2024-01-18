package F1.NB0;

import java.util.ArrayList;

public class NB0 {
    private static ArrayList<String> aList = new ArrayList<>();
    private static ArrayList<DirectoryEntry> theDirectoryList = new ArrayList<>();

    public static void main(String[] args) {
        /*

        //P2.1 - Replace
        aList.add("Alex");
        aList.add("Bob");
        aList.add("Charlie");

        System.out.println(aList.toString());
        //replace(aList, "Bob", "Erik");

        //P2.1 - Remove
        delete(aList, "Bob");
        System.out.println(aList.toString());

        //P2.2 - Add
        DirectoryEntry entry = new DirectoryEntry();
        entry.setName("Alex");
        entry.setNumber("1234");
        theDirectoryList.add(entry);

        System.out.println(theDirectoryList.get(0).toString());
        System.out.println(addOrChangeEntry("aAlex", "6234"));
        System.out.println(addOrChangeEntry("REMOVE", "6111234"));
        System.out.println(removeEntry("REMOVE"));
        System.out.println(theDirectoryList.get(0).toString());
        System.out.println(theDirectoryList.get(1).toString());
        System.out.println(theDirectoryList.get(2).toString());
        */

        NArrayList<Object> nArrayList = new NArrayList<>();
        nArrayList.add("Alex1");
        nArrayList.add("Alex2");
        nArrayList.add("Alex3");
        System.out.println(nArrayList.remove(3));
        System.out.println(nArrayList.indexOf("Alex2"));
        System.out.println(nArrayList.indexOf("Alex3"));
        System.out.println(nArrayList);


    }


    //P2,1 - Replace
    public static void replace(ArrayList<String> aList, String oldItem, String newItem) {
        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).equals(oldItem)) {
                aList.set(i, newItem);
            }
        }
    }

    //P2,1 - Remove
    public static void delete(ArrayList<String> aList, String target) {
        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).equals(target)) {
                aList.remove(i);
            }
        }
    }


    //P2.2 - Add

    public static class DirectoryEntry {
        String name;
        String number;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "DirectoryEntry{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }

    public static String addOrChangeEntry(String aName, String newNumber) {
        for (int i = 0; i < theDirectoryList.size(); i++) {
            if (theDirectoryList.get(i).name.contains(aName)) {
                String temp = theDirectoryList.get(i).number;
                theDirectoryList.get(i).number = newNumber;
                return temp;
            }
        }
        DirectoryEntry entry = new DirectoryEntry();
        entry.setName(aName);
        entry.setNumber(newNumber);
        theDirectoryList.add(entry);
        return newNumber;
    }

    //P2.2 - Remove
    public static String removeEntry(String aName) {
        for (int i = 0; i < theDirectoryList.size(); i++) {
            if (theDirectoryList.get(i).getName().equals(aName)) {
                String temp = theDirectoryList.get(i).getName();
                theDirectoryList.remove(i);
                return temp;
            }
        }
        return null;
    }


}