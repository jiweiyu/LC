package otherCompany;

/*
给一个linkedlist 每个node包含child和next指针和val要求返回flattened list. child设为null就好了
example:
1 -> 3 -> 4 -> 5
        |               |
        6-> 7       9
        |
        8

输出为1->3 -> 4 -> 5->6->7->9->8
 */
public class flattenLinkedList {

//    public Node flatten(Node start){
//
//    }


    class Node{
        int val;
        Node child;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
}
