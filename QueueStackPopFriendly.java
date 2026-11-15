/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thamasha
 */



public class QueueStackPopFriendly {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    class Queue {
        Node first, last;

        boolean empty() {
            return first == null;
        }

        void add(int value) {
            Node n = new Node(value);

            if (last == null) {
                first = last = n;
            } else {
                last.next = n;
                last = n;
            }
        }

        int remove() {
            if (empty()) {
                throw new IllegalStateException("Empty queue");
            }

            int value = first.value;
            first = first.next;

            if (first == null) {
                last = null;
            }

            return value;
        }
    }

    Queue mainQueue = new Queue();
    Queue helperQueue = new Queue();

    public void push(int value) {

        helperQueue.add(value);

        while (!mainQueue.empty()) {
            helperQueue.add(mainQueue.remove());
        }

        Queue temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;

        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (mainQueue.empty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return mainQueue.remove();
    }

    public static void main(String[] args) {

        QueueStackPopFriendly stack =
                new QueueStackPopFriendly();

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
