/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<ImmutableListNode>(); 
        if (head==null) {
           return; 
        }
             
        if (head.getNext() == null) {
            head.printValue();
            return;
        }

        ImmutableListNode node = head;
        while (node != null) {
             stack.push(node);
             node=node.getNext();
         }

        while(!stack.isEmpty()) {
             stack.pop().printValue();
         }
    }
}