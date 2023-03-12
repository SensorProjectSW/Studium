package Klausurvorbereitung;

public class Aufgabe6WS0708 {
    public static void main(String[] args) {
        List list = new List();
        List.Node zwei = new List.Node(null, 2);
        List.Node eins = new List.Node(zwei, 4);
        list.set(list.head, eins);


        System.out.println(list.lessThan(3));
        System.out.println(list.lessThanRec(3));
    }
}

class List {
    Node head;
    static class Node {
        Node next;
        int data;
        public Node (Node n, int s) {
            next = n;
            data = s;
        }
    }

    public void set(Node alt, Node neu) {
        alt.next = neu;
    }

    public List() {
        head = new Node(null, -1);
    }

    public int lessThan (int c) {
        int count = 0;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data < c) count++;
            temp = temp.next;
        }
        return count;
    }

    public int lessThanRec(int c) {
        return lessThanRec(c, head.next, 0);
    }

    public int lessThanRec (int c, Node temp, int i) {
        if (temp == null) return i;
        if (temp.data < c) return lessThanRec(c, temp.next, ++i);
        else return lessThanRec(c, temp.next, i);
    }
}
