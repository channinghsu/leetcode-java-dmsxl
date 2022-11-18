/*
344.反转字符串

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 */

public class String01_Reverse_String {
    public void reverseString(char[] s) {
        // 双指针
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            // 交换左右两个字符
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            // 继续交换下一个
            left++;
            right--;
        }
    }
}
