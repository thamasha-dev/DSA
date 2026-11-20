/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class ArrayCircularQueue {

    int[] items;
    int front;
    int rear;
    int size;

    public ArrayCircularQueue(int capacity) {

        items = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert an element
    public void enqueue(int value) {

        if (size == items.length) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % items.length;
        items[rear] = value;
        size++;

        System.out.println(value + " inserted");
    }

    // Remove an element
    public int dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = items[front];

        front = (front + 1) % items.length;
        size--;

        return value;
    }

    // Display elements
    public void display() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Elements: ");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % items.length;
            System.out.print(items[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);

        queue.display();

        System.out.println("Deleted: " + queue.dequeue());
        System.out.println("Deleted: " + queue.dequeue());

        queue.enqueue(25);
        queue.enqueue(30);
        queue.enqueue(35);

        queue.display();
    }
}
