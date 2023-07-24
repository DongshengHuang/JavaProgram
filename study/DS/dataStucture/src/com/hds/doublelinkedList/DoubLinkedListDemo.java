package com.hds.doublelinkedList;

public class DoubLinkedListDemo {
    @SuppressWarnings("{all}")
    public static void main(String[] args) {
        // node
        DoubleLinkedNode jack = new DoubleLinkedNode(1, "Jack");
        DoubleLinkedNode luck = new DoubleLinkedNode(2, "Luck");
        DoubleLinkedNode andrew = new DoubleLinkedNode(3, "Andrew");
        DoubleLinkedNode sevnt = new DoubleLinkedNode(4, "Sevent");
        // DoubleLinkedNode rechel = new DoubleLinkedNode(8, "Rechel");
        DoubleLinkedNode joes = new DoubleLinkedNode(9, "Joes");

        // doublelinkedList
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        // doubleLinkedList.add(sevnt);
        // doubleLinkedList.add(andrew);
        // doubleLinkedList.add(luck);
        // doubleLinkedList.add(jack);

        doubleLinkedList.addOrderByNode(andrew);
        doubleLinkedList.addOrderByNode(sevnt);
        doubleLinkedList.addOrderByNode(jack);
        doubleLinkedList.addOrderByNode(luck);
        doubleLinkedList.addOrderByNode(joes);
        // doubleLinkedList.addOrderByNode(rechel);
        // show
        doubleLinkedList.show();
        // reverseShow
        System.out.println("=======reverseShow========");
        doubleLinkedList.reverseShow();

        /*
         * System.out.println("====modify the value of node=======");
         * doubleLinkedList.modifyLinkedNode(rechel);
         * System.out.print("show:");
         * doubleLinkedList.show();
         * System.out.printf("reverseShow:");
         * doubleLinkedList.reverseShow();
         */

        System.out.println("=========delete the node=======");
        doubleLinkedList.deleteNode(joes);
        System.out.print("show:");
        doubleLinkedList.show();
        System.out.printf("reverseShow:");
        doubleLinkedList.reverseShow();
    }
}

// create the class of the DoubleLinkedList.
class DoubleLinkedList {
    private DoubleLinkedNode head = new DoubleLinkedNode(0, "");

    public DoubleLinkedNode getHead() {
        return head;
    }

    // write a method of add.
    public void add(DoubleLinkedNode node) {

        // determine the doublelinkedlist wether is null
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            return;
        }

        // temporary variable
        DoubleLinkedNode temp = head;

        // treverse the doubleLinkedList
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.pre = temp;
    }

    // addOrderByNode
    public void addOrderByNode(DoubleLinkedNode node) {
        // determine the linkedList is null
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            return;
        }
        // temporary variable
        DoubleLinkedNode temp = head;
        boolean flag = false;
        // treverse the linkedList
        while (temp.next != null) {
            if (temp.next.no > node.no) {
                flag = true;
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("The node is already exists");
                return;
            }
            temp = temp.next;
        }
        // determine the value of the flag
        if (flag) {
            node.next = temp.next;
            temp.next.pre = node;
            node.pre = temp;
            temp.next = node;
        } else {
            temp.next = node;
            node.pre = temp;
        }
    }

    // modify the value of node
    public void modifyLinkedNode(DoubleLinkedNode node) {
        // determine the linkedList wether is null
        if (head.next == null) {
            System.out.println("This is a null linkedList");
            return;
        }
        DoubleLinkedNode temp = head.next;
        boolean falg = false;
        // treverse the linkedList
        while (temp != null) {
            if (temp.no == node.no) {
                falg = true;
                break;
            }
            temp = temp.next;
        }
        // determine the value of flag
        if (falg) {
            temp.name = node.name;
        } else {
            System.out.println("No exists the node");
        }
    }

    // delete the node
    public void deleteNode(DoubleLinkedNode node) {
        // determine the linkedList wether is null.
        if (head.next == null) {
            System.out.println("This is a null linkedList");
            return;
        }
        // temporary variables
        DoubleLinkedNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // determine the value of flag
        if (flag) {
            node.next = temp.next.next;

            // node.next = temp.next;
            // node.pre = temp.pre;
            // temp.pre.next = node;
            // temp.next.pre = node;
        } else {
            System.out.println("No exists the node");
        }
    }

    // show
    public void show() {
        // determine the linkedList wether is null.
        if (head.next == null) {
            System.out.println("This is a null linkedList");
            return;
        }
        // temporary variable
        DoubleLinkedNode temp = head.next;
        // treverse the linkedList
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // reverse the show
    public void reverseShow() {
        // determine the linkedList is null.
        if (head.next == null) {
            System.out.println("This is a null linkedList");
            return;
        }
        // temporary variable
        DoubleLinkedNode temp = head;
        // find the last first node
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != head) {
            System.out.println(temp);
            temp = temp.pre;
        }
    }
}

// create the class of node
class DoubleLinkedNode {
    // field
    public int no;
    public String name;
    DoubleLinkedNode next, pre;

    public DoubleLinkedNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}