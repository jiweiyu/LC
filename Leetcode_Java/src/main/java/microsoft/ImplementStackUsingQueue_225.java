package microsoft;

import java.util.*;
/*
push(x), pop(), top(), empty()
stack LIFO
 */
public class ImplementStackUsingQueue_225 {

    /////1 queue, push O(n), other O(1)

    Queue<Integer> queue;
    public ImplementStackUsingQueue_225(){
        this.queue = new LinkedList<Integer>();
    }

    public void push(int x){
        queue.add(x);
        for(int i = 0;i<queue.size();i++){
            queue.add(queue.poll());
        }
    }

    public void pop(){
        queue.poll();
    }

    public int top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }

    /////2 queue, push O(1), pop O(n)
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public void push_(int x){
        q1.add(x);
        top = x;
    }

    //use q2 to temp store the removed elements from q1
    public void pop_(){
        while(q1.size()>1){
            top = q1.remove();
            q2.add(top);
        }
        q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        q1 = q2;
    }

}
