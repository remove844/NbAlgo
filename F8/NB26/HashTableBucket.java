package F8.NB26;

public class HashTableBucket<K, V> {


    private static class Entry<K, V> {

        public K key;
        public V value;


        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private SingleLinkedList<Entry<K, V>>[] table;
    private int size;


    @SuppressWarnings("unchecked")
    public HashTableBucket(int initialSize) {
        table = new SingleLinkedList[initialSize];
        size = 0;

    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        System.out.println("table length = " + table.length);
        if((table.length) * 0.75 <= size) resize();
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new SingleLinkedList<>();

        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        size++;
        table[index].addFirst(new Entry<>(key, value));
        return null;
    }

    public V remove(K key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            for (Entry<K, V> e : table[i]) {
                if(e.key.equals(key)) {
                    table[i].remove(e);
                    size--;
                    return e.value;
                }
            }
        }
        return null;
    }

    private void resize(){
        System.out.println("Inne i resize");
        System.out.println(table.length + "Tablesize");
        int reSizeTo = table.length * 2;
        SingleLinkedList<Entry<K,V>>[] temp = new SingleLinkedList[reSizeTo];
        for (SingleLinkedList<Entry<K,V>> linkedList : table) {
            if (linkedList != null){
                for (Entry<K,V> entry : linkedList) {
                    int index = entry.key.hashCode()% reSizeTo;
                    if (index < 0){
                        index += reSizeTo;
                    }
                    if (temp[index] == null){
                        temp[index] = new SingleLinkedList<>();
                    }
                    temp[index].addFirst(entry);
                }
            }
        }
        this.table = temp;
        System.out.println(table.length + "Tablesize");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            for (Entry<K,V> e : table[i]) {
                sb.append("Key=" + e.key + ", value=" + e.value + "\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashTableBucket<Integer,String> htb = new HashTableBucket<>(10);
        htb.put(1,"Harry");
        htb.put(2,"James ");
        htb.put(3,"Arnold");
        htb.put(4,"Alex");
        htb.put(5,"Harry");
        htb.put(6,"James ");
        htb.put(7,"Arnold");
        htb.put(8,"Alex");
        htb.put(9,"Alex");
//        htb.put(10,"Alex");

        System.out.println(htb.toString());
//        htb.remove(3);
        //System.out.println(htb.toString());
    }

}
