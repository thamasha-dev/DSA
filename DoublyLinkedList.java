/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */





public class DoublyLinkedList {

    class Node {

        int data;
        Node previous;
        Node next;

        Node(int value) {
            data = value;
            previous = null;
            next = null;
        }
    }

    Node head = null;
    Node tail = null;

    // Add a node at the beginning
    public void addFirst(int value) {

        Node newNode = new Node(value);

        if (head == null) {

            head = newNode;
            tail = newNode;

        } else {

            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    // Add a node at the end
    public void addLast(int value) {

        Node newNode = new Node(value);

        if (tail == null) {

            head = newNode;
            tail = newNode;

        } else {

            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    // Delete a node
    public void delete(int value) {

        Node current = head;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found");
            return;
        }

        if (current == head) {
            head = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == tail) {
            tail = current.previous;
        } else {
            current.next.previous = current.previous;
        }
    }

    // Display from beginning to end
    public void displayForward() {

        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {

            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Display from end to beginning
    public void displayBackward() {

        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {

            System.out.print(current.data + " <-> ");
            current = current.previous;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.displayForward();

        list.addFirst(5);

        list.displayForward();
        list.displayBackward();

        list.delete(20);

        list.displayForward();
        list.displayBackward();
    }
}
