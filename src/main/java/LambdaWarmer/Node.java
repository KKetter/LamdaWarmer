package LambdaWarmer;

public class Node {

    private String key;
    private String value;
    private Node next;

    public void setNext (Node node){
        this.next = node;
    }

    public void setKey (String key){
        this.key = key;
    }

    public void setValue (String value){
        this.value = value;
    }

    public String getKey() { return this.key; }

    public String getValue() { return this.value; }

    public Node getNext() { return this.next; }

    public Node (String key, String value){
        setKey(key);
        setValue(value);
    }
}
