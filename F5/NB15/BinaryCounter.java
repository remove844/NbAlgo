package F5.NB15;

public class BinaryCounter {
    public static int binC(String number){
        return binC(number, number.length() - 1, 0);
    }

    private static int binC(String number, int index, int counter){
        if(index < 0) return counter;

        int digValue = (number.charAt(index) - '0') * (int)Math.pow(2, number.length() - 1 - index);
        return binC(number,index - 1 ,counter + digValue);
    }

    public static String intToStringBin(int number){
        if(number > 0) return intToStringBin(number/2) + (number%2);
        return "";
    }

    public static void main(String[] args) {
        System.out.println(binC("1011"));
        System.out.println(intToStringBin(11));
    }
}
