package structures;

public class HashTable {

    // capacity gets incremented to mantain the load factor low.
    // load factor is n/M number of items divided by the capacity.
    // hashmap capacity modification is a costly operation.

    // to decrease collision this should be a prime number not close to a power of 2 or 10.
    final static int BUCKET_SIZE = 100;

    private final HashtableBucket[] buckets = new HashtableBucket[BUCKET_SIZE];

    public void put(Integer key, Integer value) {

        if (key == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }

        int hash = this.getHash(key);

        if (buckets[hash] != null) {
            ListNodeHash node = buckets[hash].head;
            if (node.key == key) {
                node.val = value;
            }
            while (node.next != null && node.next.key != key) {
                node = node.next;
            }
            node.next = new ListNodeHash(key, value);
        } else {
            buckets[hash] = new HashtableBucket();
            buckets[hash].head = new ListNodeHash(key, value);
        }
    }

    public Integer get(int key) {
        int hash = this.getHash(key);
        HashtableBucket bucket = buckets[hash];
        if (bucket == null) {
            return null;
        } else {
            if (bucket.head.key == key) {
                return bucket.head.val;
            }
            ListNodeHash node = bucket.head.next;
            while (node != null) {
                if (node.key == key) {
                    return node.val;
                }
                node = node.next;
            }
        }
        return null;
    }

    // distribute key uniformly into slots.
    private int getHash(int key) {
        return key % BUCKET_SIZE;
    }

    private class HashtableBucket {
        public ListNodeHash head;
    }

    private class ListNodeHash {
        public int val;
        public int key;
        public ListNodeHash next;

        public ListNodeHash(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
