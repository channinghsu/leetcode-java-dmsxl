/*
206. 反转链表
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */

public class LinkedList03_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode tmp;// 临时变量
        ListNode cur = head;// 当前节点
        ListNode pre = null;// 之前节点

        while(cur != null){ // 从前到后遍历链表
            tmp = cur.next;
            cur.next = pre; // 反转链表
            pre = cur;//向前移动pre
            cur = tmp;// 向前移动cur
        }
        return pre;// 最后cur == null; pre为头结点
    }
}
