/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Teenu
 */



public class QueueStackPushFriendly {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    class Queue {
        Node first, last;
        int size = 0;

        void add(int value) {
            Node n = new Node(value);

            if (last == null) {
                first = last = n;
            } else {
                last.next = n;
                last = n;
            }

            size++;
        }

        int remove() {
            if (first == null) {
                throw new IllegalStateException("Empty queue");
            }

            int value = first.value;
            first = first.next;

            if (first == null) {
                last = null;
            }

            size--;
            return value;
        }

        boolean empty() {
            return first == null;
        }
    }

    Queue mainQueue = new Queue();
    Queue tempQueue = new Queue();

    public void push(int value) {
        mainQueue.add(value);
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (mainQueue.empty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (mainQueue.size > 1) {
            tempQueue.add(mainQueue.remove());
        }

        int result = mainQueue.remove();

        Queue temp = mainQueue;
        mainQueue = tempQueue;
        tempQueue = temp;

        return result;
    }

    public static void main(String[] args) {

        QueueStackPushFriendly stack =
                new QueueStackPushFriendly();

        stack.push(5);
        stack.push(15);
        stack.push(25);

        System.out.println("Popped: " + stack.pop());

        stack.push(35);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
    }
}
