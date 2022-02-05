package linkedlist;

public class MyLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        Node temp = head;
        int curr = 0;
        while(temp != null) {
            if(curr == index) {
                return temp.val;
            }
            temp = temp.next;
            curr++;
        }
        return -1;
    }
    public void addAtHead(int val) {
        Node ll = new Node(val);
        ll.next = head;
        head = ll;
    }

    public void addAtTail(int val) {
        Node ll = new Node(val);
        Node temp = head;
        if(head == null) {
            addAtHead(val);
            return;
        }
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = ll;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0) return;
        if(index == 0) {
            addAtHead(val);
        } else {
            Node ll = new Node(val);

            Node temp = head;
            int curr = 0;
            while(temp != null) {
                if(curr == index -1) {
                    ll.next = temp.next;
                    temp.next = ll;
                    return;
                }
                temp = temp.next;
                curr++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if(index < 0) return;
        if(index == 0) {
            head = head.next;
        } else {
            Node temp = head;
            int curr = 0;
            while(temp.next != null) {
                if(curr == index - 1) {
                    temp.next = temp.next.next;
                    break;
                }

                temp = temp.next;
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(10);
        obj.addAtIndex(1,20);

        System.out.println(obj.get(2));
    }
}
