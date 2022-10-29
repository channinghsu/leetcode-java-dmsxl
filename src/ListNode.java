public class ListNode{
    int val;
    ListNode next;
    // 无参
    public ListNode(){}
    // 一个参数
    public ListNode(int val){
        this.val = val;
    }
    // 二个参数
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}