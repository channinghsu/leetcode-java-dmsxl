/*
160.链表相交
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

简单来说，就是求两个链表交点节点的指针。 要注意，交点不是数值相等，而是指针相等。
 */

public class LinkedList06_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 计算两个链表的大小
        ListNode curA = headA;
        ListNode curB = headB;
        int sizeA = 0, sizeB = 0;
        while (curA != null) {
            curA = curA.next;
            sizeA++;
        }
        while (curB != null) {
            curB = curB.next;
            sizeB++;
        }
        curA = headA;
        curB = headB;
        // 让A始终为最长的链表
        if (sizeB > sizeA) {
            //1. swap (lenA, lenB);
            int tmpLen = sizeA;
            sizeA = sizeB;
            sizeB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 让curA和curB在同一起点上（末尾位置对齐）
        int val = sizeA - sizeB;
        while (val-- > 0) {
            curA = curA.next;
        }
        // 同时向后移动curA和curB
        while (curA != null) {
            // 找到交点并返回
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        // 没找到焦点 返回null
        return null;
    }
}
