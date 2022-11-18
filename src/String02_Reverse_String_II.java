import java.util.Arrays;

/*
541. 反转字符串II
给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
示例:
输入: s = "abcdefg", k = 2
输出: "bacdfeg"

 */
public class String02_Reverse_String_II {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        // 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < ch.length; i += 2 * k) {
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, i + k - 1);
            reverse(ch, i, end);
            /* 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {
                reverse(ch, i, i + k - 1);
            } else {
                // 3. 剩余字符少于 k 个，则将剩余字符全部反转
                reverse(ch, i, ch.length - 1);
            }*/
        }
        return new String(ch);
    }

    // 定义翻转函数
    public void reverse(char[] s, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}