package com.hds.linkeListtwice;

import java.util.Stack;

public class SingleLinkedListDemo {
    @SuppressWarnings("{all}")
    public static void main(String[] args) {
       //node 
        LinkedNode jems = new LinkedNode(1,"Jems");
        LinkedNode jeos = new LinkedNode(2,"jeos");
        LinkedNode andrew = new LinkedNode(3, "Andrew");
        LinkedNode luck = new LinkedNode(4,"luck");
        LinkedNode jack = new LinkedNode(5, "Jack");
        LinkedNode kebo = new LinkedNode(5, "Kebo");;

        //singleLinkedList
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        LinkedNode node3 = new LinkedNode(3, "3");
        LinkedNode node4 = new LinkedNode(4, "4");
        LinkedNode node5 = new LinkedNode(5, "5");
        LinkedNode node6 = new LinkedNode(6, "6");
        LinkedNode node7 = new LinkedNode(7, "7");
        LinkedNode node8 = new LinkedNode(8, "8");
        LinkedNode node9 = new LinkedNode(9, "9");
        LinkedNode node10 = new LinkedNode(10, "10");
        LinkedNode node11 = new LinkedNode(11, "11");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList2.addOrderByLinkedNode(node11);
        singleLinkedList2.addOrderByLinkedNode(node4);
        singleLinkedList2.addOrderByLinkedNode(node9);
        singleLinkedList2.addOrderByLinkedNode(node3);
        singleLinkedList2.addOrderByLinkedNode(node7);

        singleLinkedList3.addOrderByLinkedNode(node10);
        singleLinkedList2.addOrderByLinkedNode(node4);
        singleLinkedList2.addOrderByLinkedNode(node9);
        singleLinkedList3.addOrderByLinkedNode(node5);
        singleLinkedList3.addOrderByLinkedNode(node6);
        singleLinkedList3.addOrderByLinkedNode(node8);
/*         singleLinkedList.add(jems);
        singleLinkedList.add(jeos);
        singleLinkedList.add(andrew);
        // singleLinkedList.add(jeos);
        singleLinkedList.add(luck);
        singleLinkedList.add(jack); */

        /* singleLinkedList.addOrderByLinkedNode(jack);
        singleLinkedList.addOrderByLinkedNode(andrew);
        singleLinkedList.addOrderByLinkedNode(luck);
        singleLinkedList.addOrderByLinkedNode(jems);
        singleLinkedList.addOrderByLinkedNode(jeos);
        singleLinkedList.addOrderByLinkedNode(jack);

        System.out.println("=====show singleLinkedList===========");
        singleLinkedList.showList(); */
/*         System.out.p=rintln("=======delete linkedNode==========");
        singleLinkedList.deleteLinkedNode(jems);
        singleLinkedList.showList(); */
/*         System.out.println("===========modify the value of the node===========");
        singleLinkedList.modifyLinkedNode(kebo);
        singleLinkedList.showList(); */
/*         System.out.println("========get the size of the linkedList =============");
        System.out.println("The linkedList size is: " + getLength(singleLinkedList.getHead())); */
/*         System.out.println("==========get the last index node on linkedList===========");
        System.out.println(getLsatIndexNode(singleLinkedList.getHead(), 4)); */
/*         System.out.println("===========reverse the linkedList===========");
        reverseLinkedList(singleLinkedList.getHead());
        singleLinkedList.showList(); */
       /*  System.out.println("============reverse print the linkeList==========");
        printLinkeList(singleLinkedList.getHead());
        System.out.println("the linked is:");
        singleLinkedList.showList(); */
        System.out.println("========sum the two linkedList=================");
        System.out.println("singleLinkedList2:");
        singleLinkedList2.showList();
        System.out.println("singleLinkedList3:");
        singleLinkedList3.showList();
        System.out.println("sumsingleLinkedList:");
        LinkedNode head = sumLinkedList(singleLinkedList2.getHead(), singleLinkedList3.getHead());
        if(head.next == null){
            System.out.println("This is null linkedList.");
            return;
        }
        LinkedNode temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //get the size of the LinkedList
    public static int getLength(LinkedNode head){
        //determine the linkedList wether is null.
        if(head.next == null){
            System.out.println("This is a null linkedList");
            return 0;
        }
        //treverse the linkedList
        LinkedNode temp = head.next;
        int length = 0;
        //
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    //find the last index node on linkeList
    public static LinkedNode getLsatIndexNode(LinkedNode head, int index){
        //determine the linkedList wether is null
        if(head.next == null){
            System.out.println("This is a null linkedList");
            return null;
        }
        //treverse the linkedList
        LinkedNode temp = head.next;
        for(int i = 0; i < getLength(head) - index; i++){
            temp = temp.next;
        }
        return temp;
    }
    // reverse the linkedList 
    public static void reverseLinkedList(LinkedNode head){
        //dertermin the linkedlist wether is null or only one node
        if(head.next == null || head.next.next ==null){
            return;
        }
        //temporary variable
        LinkedNode reverseHead = new LinkedNode(0, null);;
        LinkedNode cur = head.next;
        LinkedNode temp = null;
        while(cur != null){
            temp = cur;
            cur = cur.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
        }
        head.next = reverseHead.next;
    }
    //reverse print the linkedList
    public static void printLinkeList(LinkedNode head){
        //determine the linkedList is null or only one node
        if(head.next == null){
            System.out.println("This is a null linkeList");
            return;
        } else if(head.next.next == null){
            System.out.println(head.next);
            return;
        }
        // create the install of the Stack
        Stack<LinkedNode> stack = new Stack<LinkedNode>();
        LinkedNode temp = head.next;
        //into the stack
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        //out the stack 
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
    public static LinkedNode sumLinkedList(LinkedNode head1, LinkedNode head2){
        //determine the two linkedList wether is null
        if(head1.next == null && head2.next != null){
            return head2;
        }else if(head1.next != null && head2.next == null){
            return head1;
        }else if(head1.next == null && head2.next == null) {
            System.out.println("the two linkedList is null.");
            return head1;
        }
        //temporary variable
        LinkedNode temp1 = head1.next;
        LinkedNode temp2 = head2.next;
        LinkedNode head3 = new LinkedNode(0, null);
        LinkedNode temp3 = head3;
        //treverse the two linkedList
        while(temp1 != null && temp2 != null){
            if(temp1.no <= temp2.no){
                temp3.next = temp1;
                temp1 = temp1.next;
                temp3 = temp3.next;
            }else{
                temp3.next = temp2;
                temp2 = temp2.next;
                temp3 = temp3.next;
            }
        }
        //treverse non-linkedList
        if(temp1 != null){
            temp3.next = temp1;
        }
        if(temp2 != null){
            temp3.next = temp2;
        }
        return head3;
    }
}
//create the class of SingleLinkedList
class SingleLinkedList{
    //filed
    private LinkedNode head = new LinkedNode(0,null);
    public LinkedNode getHead() {
        return head;
    }
    //write the method of add()
    public void add(LinkedNode linkedNode){
        //when the linkedList is null
        LinkedNode temp = head;
        while(temp.next != null){
            if(temp.next.no == linkedNode.no && temp.next.name == linkedNode.name){
                System.out.println("The linkedNode alread exists!");
                return;
            }
            temp = temp.next;
        }
        /* linkedNode.next = temp.next;
        temp.next = linkedNode; */
        temp.next =linkedNode;
        linkedNode.next = null;
    }
    //addOrderBy
    public void addOrderByLinkedNode(LinkedNode linkedNode){
        //determine the linkedList is null.
        if(head.next == null){
            head.next = linkedNode;
            // linkedNode.next = null;
            return;
        }
        //temporary variable
        LinkedNode temp = head;
        boolean falg = false;
        //find the index of the goal
        while(temp.next != null){
            if(temp.next.no > linkedNode.no){
                falg = true;
                break;
            }else if(temp.next.no == linkedNode.no){
                System.out.printf("the num no.%d is already exists.\n",linkedNode.no);
                return;
            }
            temp = temp.next;
        }
        //operate
        if(falg){
            linkedNode.next = temp.next;
            temp.next = linkedNode;
        }else{
            temp.next = linkedNode;
        }
    }
    //delete the node on linkedList
    public void deleteLinkedNode(LinkedNode  linkedNode){
        //determine the linkedList wether is null.
        if(head.next == null){
            System.out.println("This is a null linkedList, can't operate delete node.");
            return;
        }
        LinkedNode temp = head;
        boolean falg = false;
        while(temp.next != null){
            if(temp.next.no == linkedNode.no){
                falg = true;
                break;
            }
            temp = temp.next;
        }
        if(falg){
            temp.next = temp.next.next;
            System.out.printf("The num no.%d was deleted.\n", linkedNode.no);
        }else{
            System.out.printf("No exists the linkedNode.no.%d.\n",linkedNode.no);
        }
    }
    //modify the linkedNode on linkedList
    public void modifyLinkedNode(LinkedNode linkedNode){
        //determine the linkedlist wether is null
        if(head.next == null){
            System.out.println("This is a null linkedList,can't operate modify.");
            return;
        }
        //temporary variable
        LinkedNode temp = head.next;
        boolean falg = false;
        //find the index of the goal
        while(temp != null){
            if(temp.no == linkedNode.no && temp.name != linkedNode.name){
                falg = true;
                break;
            }else if(temp.no == linkedNode.no && temp.name == linkedNode.name){
                System.out.println("The node is already exists.");
                return;
            }
            temp = temp.next;
        }
        //operate
        if(falg){
            temp.name = linkedNode.name;
            System.out.printf("The value of the  node no.%d was modify\n",linkedNode.no);
        }else{
            System.out.printf("No exists the node no.%d on linkedList\n", linkedNode.no);
        }
    }
    //showList
    public void showList(){
        if(head.next == null){
            System.out.println("This is null linkedList.");
            return;
        }
        LinkedNode temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
//create the class of linkedNode
class LinkedNode{
    //field
    public int no;
    public String name;
    public LinkedNode next;

    public LinkedNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkedNode [no=" + no + ", name=" + name + "]";
    }
}
