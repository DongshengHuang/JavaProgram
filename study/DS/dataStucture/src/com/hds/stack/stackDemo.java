package com.hds.stack;

public class stackDemo {
    public static void main(String[] args) {

        // Stack stack = new Stack();
    }
}

// create the class of Stack.
class Stack {

    private int top = -1;
    private int[] num;
    private int MAXSIZE;

    public Stack(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
        num = new int[MAXSIZE];
    }

    // determine the stack wether is null.
    public boolean isEmply() {
        if (top == -1) {
            System.out.println("The stack is null.");
            return true;
        } else {
            System.out.println("the stack is not null.");
            return false;
        }
    }

    // determine the stack is full
    public boolean isFull() {
        if (top == MAXSIZE - 1) {
            System.out.println("the stack was full.");
            return true;
        } else {
            System.out.println("the stack wasn't full");
            return false;
        }
    }

    // push the element into stack
    public void push(int a) {
        if (isFull()) {
            return;
        }
        //
        top++;
        num[top] = a;
    }

    // pop the element of stack
    public int pop() {
        if (isEmply()) {
            return -1;
        }
        int res = num[top];
        top--;
        return res;
    }

    // show the stack
    public void show() {
        if (isEmply()) {
            return;
        }
        // temporary variable
        // int temp = top;
        // treverse the stack
        for (int i = top; i > -1; i--) {
            System.out.println(num[i]);
        }
    }
}
