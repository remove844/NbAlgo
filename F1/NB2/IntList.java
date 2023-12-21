package F1.NB2;

public class IntList {
    private int[] intList;
    private int size;

    public IntList(int initialCapacity) {
        if(initialCapacity<0) throw new IllegalArgumentException("Can be negative");
        this.size = 0;
        this.intList = new int[initialCapacity];
    }
    public IntList() {
        this.size = 0;
        this.intList = new int[10];
    }

    public void add(int element){
        if(size == intList.length) reallocate();
        intList[size++] = element;
    }

    private void reallocate(){
        int[] temp = new int[intList.length * 2];
        for(int i = 0; i < intList.length; i++){
            temp[i] = intList[i];
        }
        intList=temp;
    }

    public void add(int index, int element){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
        if(size == intList.length) reallocate();
        for(int i = size; i > index; i--){
            intList[i] = intList[i - 1];
        }
        intList[index] = element;
        size++;
    }

    public int get(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
        return intList[index];
    }

    public int indexOf(int element){
        for(int i = 0; i < size; i++){
            if(intList[i] == element) return i;
        }
        return -1;
    }

    public int remove(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
        int temp = intList[index];
        for (int i = index; i < size-1; i++) {
            intList[i] = intList[i + 1];
        }
        size--;
        return temp;
    }

    public void set(int index, int element){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
        intList[index] = element;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < size; i++){
            stringBuilder.append(intList[i] + ", ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        IntList intList = new IntList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        System.out.println(intList);
        intList.add(2, 5);
        System.out.println(intList);
        System.out.println(intList.get(2));
        System.out.println(intList.indexOf(5));
        System.out.println(intList.remove(2));
        System.out.println(intList);
        intList.set(2, 6);
        System.out.println(intList);
        System.out.println(intList.size());

    }

}
