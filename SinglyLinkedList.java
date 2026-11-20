/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class SinglyLinkedList {

    class Node {

        int data;
        Node next;

        Node(int value) {
            data = value;
            next = null;
        }
    }

    Node head = null;

    // Add a node at the beginning
    public void addFirst(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
    }

    // Add a node at the end
    public void addLast(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Remove a node using its value
    public void remove(int value) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != value) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found");
        } else {
            current.next = current.next.next;
        }
    }

    // Find a value
    public boolean contains(int value) {

        Node current = head;

        while (current != null) {

            if (current.data == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display the list
    public void display() {

        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("List: ");

        while (current != null) {

            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.display();

        list.addFirst(5);
        list.display();

        list.remove(20);
        list.display();

        System.out.println("Contains 30: " + list.contains(30));
    }
}

