/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Teenu
 */


public class UnboundedArrayStack {

    private int numbers[];
    private int topIndex;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 5;
        numbers = new int[capacity];
        topIndex = -1;
    }

    private void increaseSize() {

        int newCapacity = capacity * 2;
        int newNumbers[] = new int[newCapacity];

        for (int i = 0; i <= topIndex; i++) {
            newNumbers[i] = numbers[i];
        }

        numbers = newNumbers;
        capacity = newCapacity;
    }

    private void decreaseSize() {

        if (capacity > 5 &&
                topIndex + 1 <= capacity / 4) {

            int newCapacity = capacity / 2;
            int newNumbers[] = new int[newCapacity];

            for (int i = 0; i <= topIndex; i++) {
                newNumbers[i] = numbers[i];
            }

            numbers = newNumbers;
            capacity = newCapacity;
        }
    }

    public void push(int value) {

        if (topIndex == capacity - 1) {
            increaseSize();
        }

        topIndex++;
        numbers[topIndex] = value;

        System.out.println(value + " pushed");
    }

    public int pop() {

        if (topIndex == -1) {
            throw new IllegalStateException("Stack is empty");
        }

        int value = numbers[topIndex];
        topIndex--;

        decreaseSize();

        return value;
    }

    public void display() {

        if (topIndex == -1) {
            System.out.println("Stack is empty");
            return;
        }

        for (int i = topIndex; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack =
                new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println("Current capacity: "
                + stack.getCapacity());

        stack.display();

        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());

        System.out.println("Current capacity: "
                + stack.getCapacity());

        stack.display();
    }
}
