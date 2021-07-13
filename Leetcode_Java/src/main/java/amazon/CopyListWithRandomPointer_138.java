package amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujiwei on 19/1/21.
 */
public class CopyListWithRandomPointer_138 {

    /**
     * 138. Copy List with Random Pointer
     * A linked list is given such that each node contains an additional random pointer
     * which could point to any node in the list or null.
     *
     * Return a deep copy of the list.
     */

        class RandomListNode {
            int label;
            RandomListNode next, random;
            RandomListNode(int x) {
                this.label = x;
            }
        }

//        public RandomListNode copyRandomList(RandomListNode head) {
//            if(head == null)
//                return null;
//
//            Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//
//            return copyRandom(head, map);
//        }

//        public RandomListNode copyRandpublic RandomListNode copyRandomList(RandomListNode head) {
////            if(head == null)
////                return null;
////
////            Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
////
////            return copyRandom(head, map);
////        }om(RandomListNode head, HashMap<RandomListNode, RandomListNode> newmap){
//
//            if(head == null){
//                return null;
//            }
//
//            if(newmap.containsKey(head)){
//                return newmap.get(head);
//            }
//
//            RandomListNode newHead = new RandomListNode(head.label);
//            newmap.put(head, newHead);
//            newHead.next = copyRandom(head.next, newmap);
//            newHead.random = copyRandom(head.random, newmap);
//
//            return newHead;
//        }

}
