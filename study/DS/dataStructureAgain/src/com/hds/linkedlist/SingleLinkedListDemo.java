package com.hds.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    @SuppressWarnings("{all}")
    public static void main(String[] args) {
        // generate LinkedNode
        LinkedNode steven = new LinkedNode(1, "Steven", 1300);
        LinkedNode andrew = new LinkedNode(2, "Andrew", 1500);
        LinkedNode joes = new LinkedNode(3, "Joes", 2000);
        LinkedNode jack = new LinkedNode(4, "jack", 800);
        LinkedNode luck = new LinkedNode(5, "luck", 1200);
        LinkedNode jems = new LinkedNode(6, "Jems", 3000);
        LinkedNode flek = new LinkedNode(7, "flek", 6000);
        LinkedNode kobe = new LinkedNode(8, "kobe", 9000);
        // Create SingleLinkedList
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(steven);
        singleLinkedList.add(andrew);
        singleLinkedList.add(joes);
        singleLinkedList.add(jack);
        singleLinkedList.add(luck);
        singleLinkedList.add(jems);
        singleLinkedList.add(kobe);
        singleLinkedList.add(flek);

        // //showList
        singleLinkedList.showList();
        // delete node
        /*
         * System.out.println("=======delete node==========");
         * singleLinkedList.deleteNOde(4);
         * singleLinkedList.showList();
         */
        /*
         * System.out.println("===========modify before===========");
         * singleLinkedList.modifyNodeValue(flek);
         * // singleLinkedList.showList();
         */
        /*
         * System.out.println("===========the size of linkedList.=============");
         * System.out.println("the number of node in linkedList:" +
         * getLength(singleLinkedList.getHead()));
         */
        /*
         * System.out.println("=========find the last k of node===============");
         * System.out.println(findLastIndexNode(singleLinkedList.getHead(), 4));
         */
        /*
         * System.out.println("==============reverse the linkedList==============");
         * reverseLinkeList(singleLinkedList.getHead());
         * singleLinkedList.showList();
         */
        System.out.println("========reserver print the linkedList==============");
        reversePrint(singleLinkedList.getHead());
        // singleLinkedList.showList();
    }

    // get the size of the linkedList.
    public static int getLength(LinkedNode head) {
        // determine null
        if (head.next == null) {
            System.out.println("This is a null linkedList.");
            return 0;
        }
        // variable
        int length = 0;
        LinkedNode temp = head.next;
        // action treverse the linkedList.
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // find the last k node on linkedList
    public static LinkedNode findLastIndexNode(LinkedNode head, int index) {
        // determine
        if (head.next == null) {
            System.out.println("This is a null linkedList.");
            return null;
        }
        // temporary variables
        LinkedNode temp = head.next;
        // treverse the index of number
        for (int i = 0; i < getLength(head) - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // reverse the linkedList
    public static void reverseLinkeList(LinkedNode head) {
        // determine null and only one node
        if (head.next == null || head.next.next == null) {
            return;
        }
        // temporate variables
        // create new reverseHead
        LinkedNode reserverHead = new LinkedNode(0, null, 0);
        ;
        LinkedNode cur = head.next;
        LinkedNode temp = null;
        // reverse the linkedList.
        while (cur != null) {
            temp = cur;
            cur = cur.next;
            temp.next = reserverHead.next;
            reserverHead.next = temp;
        }
        // head.next index to first the node of the reservered LinkedList.
        head.next = reserverHead.next;
    }

    // reversePrint the linkedList
    public static void reversePrint(LinkedNode head) {
        // determine the linked wether is null.
        if (head.next == null) {
            System.out.println("This is a null linkedList");
            return;
        }
        // create statck
        Stack<LinkedNode> stack = new Stack<LinkedNode>();
        // the LinkedNode into statck
        LinkedNode temp = head.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

class SingleLinkedList {
    /*
     * field
     */
    // head node
    private LinkedNode head = new LinkedNode(0, "", 0.0);

    public LinkedNode getHead() {
        return head;
    }

    // temporary variables
    // LinkedNode temp = head;
    /*
     * method of SingleLinkedList
     */
    public void add(LinkedNode node) {
        LinkedNode temp = head;
        // if(temp.next ==null){
        // temp.next = node;
        // }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    // ByOrder
    public void addListByOrder(LinkedNode node) {
        LinkedNode temp = head;
        /*
         * //find the index of node
         * boolean flag = false;
         * while (true){
         * if(temp.next == null || temp.next.no > node.no){
         * break;
         * }else if(temp.next.no == node.no){
         * flag = true;
         * }
         * temp = temp.next;
         * }
         * if(flag){
         * System.out.printf("Already exists no.%d of node", node.no);
         * }else {
         * node.next = temp.next;
         * temp.next = node;
         * }
         */
        // when find the index of node ,add
        while (true) {
            if (temp.next == null || temp.next.no > node.no) {
                node.next = temp.next;
                temp.next = node;
                break;
            } else if (temp.next.no == node.no) {
                System.out.printf("Already exists no.%d of the node!\n", node.no);
                break;
            }
            temp = temp.next;
        }
    }

    // modify the value of linkednode.
    public void modifyNodeValue(LinkedNode node) {
        LinkedNode temp = head.next;
        if (temp == null) {
            System.out.println("This is a null linkedList!");
            return;
        }
        // flag
        boolean flag = false;
        // find the index of modifyNode
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.money = node.money;
        } else {
            System.out.printf("No exists no.%d of node\n", node.no);
        }
    }

    // delete LinkedNode
    public void deleteNOde(int no) {
        LinkedNode temp = head;
        if (temp.next == null) {
            System.out.println("This is null LinkedList");
            return;
        }
        // flag
        boolean flag = false;
        // find the index of delete node
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // determine whether delete the node
        if (flag) {
            temp.next = temp.next.next;
            System.out.printf("no.%d of the node was deleted!\n", no);
        } else {
            System.out.printf("Not find the no.%d of node\n", no);
        }

    }

    public void showList() {
        LinkedNode temp = head;
        if (temp.next == null) {
            System.out.println("This is null linkedList");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

// Node class
class LinkedNode {
    // field
    public int no;
    public String name;
    public double money;
    LinkedNode next;

    public LinkedNode(int no, String name, double money) {
        this.no = no;
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
