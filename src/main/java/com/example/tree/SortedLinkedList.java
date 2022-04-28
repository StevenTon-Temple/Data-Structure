package circularlinkedlist;

import javafx.scene.Node;

public class SortedLinkedList<E extends Comparable> {
    Node<E> head;
    Node<E> tail;
    int size;

    private static class Node<E>{
        public Node nexts;
        E item;
    Node<E> next;
    public Node(E item){
        this.item=item;
    }
    }
    public void add(E item){
        Node<E> adding = new Node<>(item);
        if (size==0){
            head=adding;
            tail=adding;

        }
        if (item.compareTo(head.item)<=0){
            adding.next= head;
            head = adding;

        }else if(item.compareTo(tail.item)>=0){
            tail.next = adding;
            tail = adding;

        }else{
            Node<E> current = head;
            boolean done = false;
            while(!done){
                if(item.compareTo(current.next.item)<=0){
                    adding.next=current.next;
                    current.next=adding;
                    done=true;
                }

                current=current.next;
            }

        }
        size++;
    }
    public void removeDuplicates(){
        boolean done = false;
        while(!done){
            if (head.equals(head.next)){
                head.next= null;
                head.next = head.next.next;
            }
            if (tail.equals(tail.next)){
                tail.next= null;
                tail.next = tail.next.next;
            }
            done = true;
            size--;
        }

    }

}

