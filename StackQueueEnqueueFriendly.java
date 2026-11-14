/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Teenu
 */


public class StackQueueEnqueueFriendly {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    class Stack {
        Node top;

        void push(int value) {
            Node n = new Node(value);
            n.next = top;
            top = n;
        }

        int pop() {
            if (top == null) {
                throw new IllegalStateException("Stack is empty");
            }

            int value = top.value;
            top = top.next;

            return value;
        }

        boolean empty() {
            return top == null;
        }
    }

    Stack firstStack = new Stack();
    Stack secondStack = new Stack();

    public void enqueue(int value) {
        firstStack.push(value);
        System.out.println("Added: " + value);
    }

    public int dequeue() {

        if (firstStack.empty()) {
            throw new IllegalStateException("Queue is empty");
        }

        while (!firstStack.empty()) {
            secondStack.push(firstStack.pop());
        }

        int result = secondStack.pop();

        while (!secondStack.empty()) {
            firstStack.push(secondStack.pop());
        }

        return result;
    }

    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue =
                new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Removed: " + queue.dequeue());

        queue.enqueue(40);

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());
    }
}
