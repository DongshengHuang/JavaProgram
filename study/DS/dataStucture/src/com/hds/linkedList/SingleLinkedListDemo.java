package com.hds.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    @SuppressWarnings("{all}")
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "1", "1");
        HeroNode heroNode2 = new HeroNode(2, "2", "2");
        HeroNode heroNode3 = new HeroNode(3, "3", "3");
        HeroNode heroNode4 = new HeroNode(4, "4", "4");
        HeroNode heroNode5 = new HeroNode(5, "5", "5");
        HeroNode heroNode6 = new HeroNode(6, "6", "6");
        HeroNode heroNode7 = new HeroNode(6, "7", "7");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOreder(heroNode4);
        singleLinkedList.addByOreder(heroNode2);
        singleLinkedList.addByOreder(heroNode1);
        singleLinkedList.addByOreder(heroNode5);
        singleLinkedList.addByOreder(heroNode3);
        singleLinkedList.addByOreder(heroNode6);
        singleLinkedList.addByOreder(heroNode1);

        System.out.println("=====origin linkedList=========");
        singleLinkedList.showList();
        System.out.println("=====delete the node=======");
        singleLinkedList.deleteNode(heroNode5);
        singleLinkedList.showList();
        System.out.println("=======modify the value of node in linkedList.==========");
        singleLinkedList.modifyNodeValue(heroNode7);
        singleLinkedList.showList();

        // System.out.println("========The number of LinkedList");
        // int size = getLength(singleLinkedList.getHead());
        // System.out.printf("the linkedList have %d of node\n", size);
        // System.out.println("========findLastindexNode");
        // System.out.println(findLastindexNode(singleLinkedList.getHead(), 3));
        // System.out.println("===========reverse the linkedList==========");
        // reverseLinkeList(singleLinkedList.getHead());
        // singleLinkedList.showList();
        // HeroNode head = reverseLinkeList(singleLinkedList.getHead());
        // HeroNode temp = head.next;
        // if(head != null){
        // HeroNode temp = head;
        // while(temp.next != null){
        // System.out.println(temp.next);
        // temp = temp.next;
        // }
        // }
        // System.out.println("======reversePrint the linkedNode==========");
        // reversePrint(singleLinkedList.getHead());
    }

    // get the size of LinkedList
    public static int getLength(HeroNode head) {
        // determine the linkedList whether is null
        if (head.next == null) {
            System.out.println("This is null LinkedList ,only contain zero element");
            return 0;
        }
        HeroNode cur = head.next;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    // get anti-number the k of the node
    public static HeroNode findLastindexNode(HeroNode head, int index) {
        // determine the linkedList whther is null.
        if (head.next == null) {
            System.out.println("This is null linkedList");
            return null;
        }
        // find the last index of the node
        HeroNode cur = head.next;
        // get the size of the linkedList.
        int size = getLength(head);
        // determine the value of index whether is the arange of size.
        if (index <= 0 || index > size) {
            System.out.println("ileage the value of index");
            return null;
        }
        // twice traverse the linkedList.
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // the reverse of the linkedList
    public static void reverseLinkeList(HeroNode head) {
        // determine the linkedList wether is null linkedList.
        if (head.next == null || head.next.next == null) {
            // System.out.println("This is a null LinkedList.");
            return;
        }
        // create new serverseHead node.
        // HeroNode reverseHead = head; // 不能这么写，此时reversehead 和 head 指向同一个对象
        // reverseHead.next = null;
        // System.out.println(head.next);
        HeroNode reverseHead = new HeroNode(0, null, null);
        // move cur
        HeroNode cur = head.next;
        HeroNode temp = null;
        // treverse the linkedList
        while (cur != null) {
            temp = cur;
            cur = cur.next;
            temp.next = reverseHead.next;
            // reverseHead.next = temp.next;
            reverseHead.next = temp;
        }
        head.next = reverseHead.next;
    }

    // write a method that can be reverse print LinkedList node.
    public static void reversePrint(HeroNode head) {
        // determine the linkedList wether is null.
        if (head.next == null) {
            System.out.println("Thsi is a null linkedList.");
            return;
        }
        // creat variable.
        HeroNode cur = head.next;
        // create a object of the statck.
        Stack<HeroNode> stack = new Stack<HeroNode>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // print the element of the stack.
        /*
         * int size = stack.size();
         * for(int i = 0; i < size;i++){
         * System.out.println(stack.pop());
         * }
         */
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOreder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null || temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("Already exists no.%d!\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
        /*
         * while (true) {
         * if (temp.next == null) {
         * temp.next = heroNode;
         * break;
         * }
         * // temp = temp.next;
         * if (temp.next.no > heroNode.no) {
         * heroNode.next = temp.next;
         * temp.next = heroNode;
         * return;
         * } else if (temp.next.no == heroNode.no) {
         * // flag = true;
         * System.out.print("Alread exists %d !\n");
         * break;
         * }
         * temp = temp.next;
         */
    }

    // delete the node of the linkedList.
    public void deleteNode(HeroNode heronode) {
        // determine the linkedList whther is null.
        if (head.next == null) {
            System.out.println("Thiis is a null linkedList.");
            return;
        }
        // variable
        HeroNode temp = head;
        boolean falg = false;
        // find the index of the heronode
        while (temp.next != null) {
            if (temp.next.no == heronode.no) {
                // fined the node,falg = true.
                falg = true;
                break;
            }
            temp = temp.next;
        }
        // delete operate.
        if (falg) {
            temp.next = temp.next.next;
        } else {
            System.out.println("No exists the heronode in the linkedList.");
        }
    }

    // modify the value of node in linkeList.
    public void modifyNodeValue(HeroNode heroNode) {
        // determine the linked whther is null.
        if (head.next == null) {
            System.out.println("This is null linked.");
            return;
        }
        // variable
        HeroNode temp = head.next;
        boolean falg = false;
        // find the index of heroNode
        while (temp != null) {
            if (temp.no == heroNode.no) {
                // finded the index.
                falg = true;
                break;
            }
            temp = temp.next;
        }
        // operate.
        if (falg) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            System.out.println("No exists the node.");
        }

    }

    public void showList() {
        HeroNode temp = head.next;
        if (temp == null) {
            System.out.println("null linkedList.");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + "]";
    }
}
