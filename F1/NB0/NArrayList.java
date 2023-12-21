package F1.NB0;

import java.util.Arrays;

public class NArrayList<E> {
    private E[] data;
    private int nrElements;
    private int maxSize;

    public NArrayList() {
        this.nrElements = 0;
        this.maxSize = 10;
        this.data = (E[]) new Object[maxSize];
    }

    public boolean add(E element){
        if(nrElements == maxSize){
            reallocate();
        }
        data[nrElements++] = element;
        return true;
    }

    public void add(int index, E element){
        if(0 <= index && index <= nrElements) {
            if (nrElements == maxSize) {
                reallocate();
            }
            for (int i = nrElements; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = element;
            nrElements++;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    private void reallocate(){
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }

    public E get(int index){
        if(0 <= index && index < nrElements){
            return data[index];
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public E remove(int index){
        if(index < 0 || index >= data.length) throw new ArrayIndexOutOfBoundsException(index);
        E element = data[index];
        for(int i = index + 1; i < data.length; i++){
            data[i - 1] = data[i];
        }
        return element;
    }

    public int indexOf(E element){
        for(int i = 0; i < data.length; i++){
            if(data[i] != null && data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public E set(int index, E element){
        if(index < 0 || index >= data.length) throw new ArrayIndexOutOfBoundsException(index);
        E old = data[index];
        data[index] = element;
        return old;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length; i++){
            if(data[i] != null) sb.append(data[i] + ", ");
        }
        return sb.toString();
    }
}
