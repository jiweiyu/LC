package microsoft;

import java.util.*;

/*
push(x), pop(), peek(), empty()
 */
public class ImplementQueueUsingStacks_232 {

    //two stacks, push O(n), pop O(1)
    private int front;
    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();

    //push s1 element to s2, and push new element to s1, copy s2 back
    public void push(int x){
        if(s1.empty()){
            front = x;
        }
        while( !s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while( !s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public void pop(){
        s1.pop();
        if(!s1.isEmpty()){
            front = s1.peek();
        }
    }

    public int peek(){
        return front;
    }

    public boolean empty(){
        return s1.isEmpty();
    }

}
