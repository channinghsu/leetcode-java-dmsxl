/*
707. 设计链表
设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。
如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

在链表类中实现这些功能：

get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。

链接：https://leetcode.cn/problems/design-linked-list
 */
public class LinkedList02_Design_Linked_List {

    int size;    //size存储链表元素的个数
    ListNode dummyHead;    //虚拟头结点

    public LinkedList02_Design_Linked_List() { // 构造方法
        size = 0;
        dummyHead = new ListNode(0);
    }

    //获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        //如果index非法，返回-1
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode cur = dummyHead;
        while (index >= 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    //在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        size++;
        // addAtIndex(0, val);
    }

    // 将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
        // addAtIndex(size,val);
    }

    // 在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
    // 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyHead;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    // 如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode cur = dummyHead;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        size--;
    }
}
/*
  Your MyLinkedList object will be instantiated and called as such:
  MyLinkedList obj = new MyLinkedList();
  int param_1 = obj.get(index);
  obj.addAtHead(val);
  obj.addAtTail(val);
  obj.addAtIndex(index,val);
  obj.deleteAtIndex(index);
 */