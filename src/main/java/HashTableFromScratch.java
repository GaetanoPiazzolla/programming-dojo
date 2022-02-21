import structures.HashTable;

public class HashTableFromScratch {

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(1, 10);
        table.put(1, 100);
        table.put(101, 100);

        table.put(2, 20);
        System.out.println(table.get(1));
        System.out.println(table.get(101));
        System.out.println(table.get(2));

    }


}
