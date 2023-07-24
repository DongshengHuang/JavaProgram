package com.hds.stack;

import java.util.Scanner;

public class LinkedStackDemo {
    @SuppressWarnings("{all}")
    public static void main(String[] args) {

        
        LinkedNode lisa = new LinkedNode(0, "Lisa");
        LinkedNode luck = new LinkedNode(1, "Luck");
        LinkedNode rechel = new LinkedNode(2, "Rechel");
        LinkedNode setven = new LinkedNode(3, "Setven");
        LinkedNode andrew = new LinkedNode(4, "Andrew");

        LinkedStack stack = new LinkedStack(4);
        // stack.show();
        stack.push(andrew);
        stack.push(luck);
        stack.push(rechel);
        stack.push(setven);
        stack.show();
        stack.push(andrew);
        // stack.show();
        // stack.pop();
        // stack.show();
        // stack.pop();
    }
}

// linkedStack
class LinkedStack {
    // LinkedNode top = null;
    private int top = -1;
    // LinkedNode stack;
    private LinkedNode head = new LinkedNode(-1, null);
    private int MAXSIZE;

    public LinkedStack(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
    }

    // determine the stack wether is full
    public boolean isFull() {
        if (top == MAXSIZE - 1) {
            return true;
        } else {
            return false;
        }
    }

    // determine the stack wether is empty
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    // push element of stack
    public void push(LinkedNode node) {
        if (isFull()) {
            System.out.println("the stack was full");
            return;
        }
        top++;
        node.next = head.next;
        head.next = node;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("the stack was empty");
            return;
        }
        head.next = head.next.next;
        top--;
    }

    // show element of the stack
    public void show() {
        if (isEmpty()) {
            System.out.println("the stack was empty,can't show the element");
            return;
        }
        LinkedNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

/*
 * // single-linked
 * class SingleLinked {
 * LinkedNode head = new LinkedNode(0, null);
 * 
 * // add node
 * public void addLinked(LinkedNode node) {
 * // head insert
 * node.next = head.next;
 * head.next = node;
 * }
 * 
 * // delete node
 * public void deleteNode() {
 * if (head.next == null) {
 * System.out.println("This is a null linkedList.");
 * return;
 * }
 * head.next = head.next.next;
 * }
 * 
 * // show single-linkedList
 * public void show() {
 * if (head.next == null) {
 * System.out.println("This is a null linkedList");
 * return;
 * }
 * 
 * LinkedNode temp = head.next;
 * 
 * while (true) {
 * if (temp == null) {
 * break;
 * }
 * System.out.println(temp);
 * temp = temp.next;
 * }
 * }
 * }
 * 
 */// linked-node
class LinkedNode {

    public int no;
    public String name;
    LinkedNode next;

    public LinkedNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "stack=[" + no + "," + name + "]";
    }

}
