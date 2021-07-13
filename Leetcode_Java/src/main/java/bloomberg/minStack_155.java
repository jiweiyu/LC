package bloomberg;

import java.util.Stack;

/**
 * Created by yujiwei on 18/7/7.
 */
public class minStack_155 {


    //Stack
    class MinStack_stack{

        private final Stack<Integer> minStack = new Stack<>();
        private final Stack<Integer> stack = new Stack<>();

        public MinStack_stack(){}

        public void push(int x){
            stack.push(x);
            if(minStack.isEmpty() || x<=minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop(){
            if(stack.peek().equals((minStack.peek()))){
                minStack.pop();
            }
            stack.pop();
        }

        public int top(){
            return stack.peek();
        }

        public int getMin(){
            return minStack.peek();
        }

    }




    //Node with min
    class MinStack {
        private Node head;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if(head == null){
                head = new Node(x, x);
            }else{
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private class Node{
            int val;
            int min;
            Node next;

            private Node(int val, int min){
                this(val, min, null);
            }

            private Node(int val, int min, Node next){
                this.val = val;
                this.min = min;
                this.next = next;
            }

        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


}
