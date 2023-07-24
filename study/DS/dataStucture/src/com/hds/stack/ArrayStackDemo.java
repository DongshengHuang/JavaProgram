package com.hds.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        //
        while (loop) {

            System.out.println("show: print the element of stack");
            System.out.println("pop:the element get out");
            System.out.println("push:the element into the stack");
            System.out.println("exit:exit the while");
            System.out.printf("please the options:");
            key = scanner.next();

            switch (key) {
                case "show":
                    stack.show();
                    break;
                case "pop":
                    try {
                        int value = stack.pop();
                        System.out.printf("stack value=%d\n", value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.printf("please input the int number:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "exit":
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
        System.out.println("the program was exit.");
    }

}

// stack
class ArrayStack {
    // field
    private int MAXSIZE;
    private int[] stack;
    private int top = -1;

    // constructor
    public ArrayStack(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
        stack = new int[this.MAXSIZE];
    }

    // method
    // determine the stack wether is null
    public boolean isEmply() {
        return top == -1;
    }

    // determine the stack wether is full
    public boolean isFull() {
        return top == MAXSIZE - 1;
    }

    // push
    public void push(int value) {
        // determine the stack wether is full
        if (isFull()) {
            System.out.println("the stack was full");
            return;
        }
        top++;
        stack[top] = value;
    }

    // pop
    public int pop() {
        // determine the stack wether is emply
        if (isEmply()) {
            throw new RuntimeException("the stack was emply");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // show
    public void show() {
        if (isEmply()) {
            System.out.println("the stack is emply");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
