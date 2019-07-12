package LambdaWarmer;

public class Hashtable {

    private Node[] map;

    public Hashtable(int size){
        map = new Node[size];
    }

    //hash: takes in an arbitrary key and returns an index in the collection.
    public int hash(String key){
        int hashValue = 0;
        char[] letters = key.toCharArray();
        for(int i=0; i< letters.length; i++){
            hashValue += letters[i];
        }
        hashValue = (hashValue * 599) % map.length;
        return hashValue;
    }

    //add: takes in both the key and value.
        //Object put(Object key, Object value)
    public void add(String key, String value){
        if(this.contains(key) == true){
            System.out.println("This key exists- try another");
        } else {
            int hashkey = hash(key);
            Node node = new Node(key, value);
            if (this.map[hashkey] == null) {
                map[hashkey] = node;
            }
            //if yes add it and set its next to the one that was already there
            else {
                Node temp = map[hashkey];
                map[hashkey] = node;
                map[hashkey].setNext(temp);
            }
        }
    }

    //Object get(Object key) - https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
    //get: takes in the key and returns the value from the table
    public String get(String key){
        int bucketIndex = hash(key);
        Node head = map[bucketIndex];
        while(head != null){
            if(head.getKey() == key) {
                return head.getValue();
            }
            head = head.getNext();
        }
        return null;
    }

    //contains: takes in the key and returns a boolean, indicating if the key exists in the table already
    public boolean contains(String key){
        int containsHashKey = hash(key);
        while(this.map[containsHashKey] != null){
            if(this.map[containsHashKey].getKey().equals(key)){
                return true;
            }
            this.map[containsHashKey] = this.map[containsHashKey].getNext();
        }
        return false;
    }


}
