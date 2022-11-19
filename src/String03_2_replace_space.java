/*
题目：剑指Offer 05.替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1： 输入：s = "We are happy."
输出："We%20are%20happy."
 */
public class String03_2_replace_space {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        //扩充空间，空格数量2倍
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        //左指针：指向原始字符串最后一个位置
        int i = s.length() - 1;
        s += sb.toString();
        char[] ch = s.toCharArray();
        //右指针：指向扩展字符串的最后一个位置
        int right = ch.length - 1;
        // 从后往前遍历
        for (; i >= 0; i--) {
            if (ch[i] == ' ') {
                ch[right--] = '0';
                ch[right--] = '2';
                ch[right] = '%';
            } else {
                ch[right] = ch[i];
            }
            right--;
        }
        return new String(ch);
    }
}
