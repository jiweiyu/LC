package microsoft;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/*
Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

TreeMap

The TreeMap in Java is used to implement Map interface and NavigableMap along with the Abstract Class.
The map is sorted according to the natural ordering of its keys,
or by a Comparator provided at map creation time,

 */
public class maxStack_716 {

    Node head;
    Node tail;
    TreeMap<Integer, List<Node>> map;

    //head <-> tail
    public void MaxStack(){
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
        map = new TreeMap<>();
    }

    // head <-> newNode <->tail
    public void push(int x){
        Node newNode = new Node(x);
        newNode.pre = tail.pre;
        newNode.next = tail;
        tail.pre.next = newNode;
        tail.pre = newNode;
        if(!map.containsKey(x)){
            map.put(x, new ArrayList<Node>());
        }
        map.get(x).add(newNode);
    }

    public int pop(){
        int value = tail.pre.val;
        removeNode(tail.pre);
        int listSize = map.get(value).size();
        map.get(value).remove(listSize - 1);
        if(listSize == 1){
            map.remove(value);
        }
        return value;
    }

    public int top(){
        return tail.pre.val;
    }

    public int peekMax(){
        return map.lastKey();
    }

    public int popMax(){
        int maxVal = map.lastKey();
        int listSize = map.get(maxVal).size();
        Node node = map.get(maxVal).remove(listSize-1);
        removeNode(node);
        if(listSize == 1){
            map.remove(maxVal);
        }
        return maxVal;
    }

    //preNode <-> (n) <-> nextNode
    //preNode <-> nextNode
    private void removeNode(Node n){
        Node preNode = n.pre;
        Node nextNode = n.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }


    class Node{
        Node pre;
        Node next;
        int val;
        public Node(int x){
            this.val = x;
            this.pre = null;
            this.next = null;
        }
    }

    //use stack

    Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public maxStack_716() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push_(int x) {
        pushHelper(x);
    }

    public void pushHelper(int x) {
        int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (x > tempMax) {
            tempMax = x;
        }
        stack.push(x);
        maxStack.push(tempMax);
    }

    public int pop_() {
        maxStack.pop();
        return stack.pop();
    }

    public int top_() {
        return stack.peek();
    }

    public int peekMax_() {
        return maxStack.peek();
    }

    public int popMax_() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();

        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while (!temp.isEmpty()) {
            int x = temp.pop();
            pushHelper(x);
        }
        return max;
    }

}
