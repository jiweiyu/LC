package leetcode;
import java.util.*;
public class PrintImmutableLinkedListInReverse_1265 {

    interface ImmutableListNode {
      public void printValue(); // print the value of this node.
      public ImmutableListNode getNext(); // return the next node.
  };

    public void printLinkedListInReverse_iterative(ImmutableListNode head) {
        if (head == null) {
            return;
        }
        printLinkedListInReverse_iterative(head.getNext());
        head.printValue();
    }

    public void printLinkedListInReverse_stack(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }
}
