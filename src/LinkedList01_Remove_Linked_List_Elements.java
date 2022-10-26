/*
203. 移除链表元素
        给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class LinkedList01_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1,head);// 虚拟头结点
        ListNode pre = dummy;// 当前循环前面的节点
        ListNode cur = head;//当前循环节点

        while(cur != null){
            if(cur.val == val){ // 若当前节点值为val
                pre.next = cur.next; // 删除当前节点
            }else {
                pre = cur; // 向前移动pre
            }
            cur = cur.next; // 向前移动当前节点
        }
        return dummy.next;
    }
}
