package priject1;

public class LinkedListDeque<Blorp> {

    private class Node {

        public Blorp item;
        public Node next;
        public Node prev;

        public Node(Blorp i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        size = 0;
    }

    public LinkedListDeque(Blorp x) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(x, null, null);
        size = 1;
    }

    public void addFirst(Blorp x){
        Node a = new Node(x,sentinel,sentinel.next);
        sentinel.next.prev = a;
        sentinel.next = a;
        size++;
    }

    public void addLast(Blorp x){
        Node p = sentinel;
        while (p.next!=null){
            p=p.next;
        }
        p.next = new Node(x,p,null);

    }


    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(Node p = sentinel.next;p != null; p=p.next){
            System.out.print(p.item + " ");
        }
    }

    public Blorp removeFirst(){
        Node p = sentinel.next;
        if(p == null){
            return null;
        }
        p.next.prev=sentinel;
        sentinel.next = p.next;


        return p.item;
    }
    public Blorp removeLast(){
        Node p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        if(p == sentinel){
            return null;
        }

        p.prev.next = null;
        return p.item;

    }
    public Blorp get(int index){
        return get(index, sentinel.next);
    }

    private Blorp get(int index, Node p){
        if(index > size-1){
            return null;
        }
        if(index == 0){
            return p.item;
        }
        return get(index - 1, p.next);

    }

    



}
