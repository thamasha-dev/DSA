/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.util.Stack;

public class StackQueueDequeueFriendly {

    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> secondStack = new Stack<>();

    // Add an element
    public void enqueue(int value) {

        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }

        firstStack.push(value);

        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }

        System.out.println(value + " added");
    }

    // Remove the oldest element
    public int dequeue() {

        if (firstStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return firstStack.pop();
    }

    // Display queue elements in FIFO order
    public void display() {

        if (firstStack.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = firstStack.size() - 1; i >= 0; i--) {
            System.out.print(firstStack.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly queue =
                new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Removed: " + queue.dequeue());

        queue.enqueue(40);

        queue.display();

        System.out.println("Removed: " + queue.dequeue());
    }
}
