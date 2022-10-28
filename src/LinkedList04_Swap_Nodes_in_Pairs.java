
/*
24. 两两交换链表中的节点
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

要画图才可以
 */
public class LinkedList04_Swap_Nodes_in_Pairs {
    public ListNode swapPairsDummyHead(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next;
            ListNode tmp1 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = tmp;
            cur.next.next.next = tmp1;
            cur = cur.next.next;
        }
        return dummyHead.next;
    }

    /*递归
        1. 找终止条件：本题终止条件很明显，当递归到链表为空或者链表只剩一个元素的时候，没得交换了，自然就终止了。
        2. 找返回值：返回给上一层递归的值应该是已经交换完成后的子链表。
        3. 单次的过程：因为递归是重复做一样的事情，所以从宏观上考虑，只用考虑某一步是怎么完成的。
            我们假设待交换的俩节点分别为head和next，next的应该接受上一级返回的子链表(参考第2步)。就相当于是一个含三个节点的链表交换前两个节点，就很简单了，想不明白的画画图就ok。
     */
    public ListNode swapPairsRecursion(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) return head;
        // 交换
        ListNode next = head.next;
        head.next = swapPairsRecursion(next.next);
        next.next = head;
        return next;
    }
}