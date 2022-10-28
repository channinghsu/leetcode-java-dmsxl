public class LinkedList05_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode(-1, head);// 虚拟头结点
        ListNode slow = dummyhead, fast = dummyhead; // 快慢节点
        for (int i = 0; i < n; i++) {// fast先走n + 1步，
            fast = fast.next;
        }
        while (fast.next != null) {// 当快节点不是最后一个节点时，快慢节点同时向前移动
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;// slow指向删除节点的上一个节点，删除slow后一个节点
        return dummyhead.next; // 返回头结点
    }
}
