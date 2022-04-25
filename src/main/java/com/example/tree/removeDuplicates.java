package com.example.maze;

// Java program to remove duplicates from a sorted linked list
class removeDuplicates{
    public Node head;
    public int size;
    public Node tail;

    static class Node {
        int data;
        Node next;
        Node(int d) {
            this.data = d;
        }
    }

    public void removeDuplicates() {
        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                if (current.next.next == null) {
                    current.next = null;
                    tail = current;
                } else {
                    current.next = current.next.next;

                }
                size--;
            }else {
                current = current.next;
            }

        }
    }

    public void push(int new_data)
    {

        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
        size++;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {

        removeDuplicates llist = new removeDuplicates();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);

        System.out.println("List before removal of duplicates");
        llist.printList();

        System.out.println("List after removal of elements");
        llist.removeDuplicates();
        llist.printList();


    }
}