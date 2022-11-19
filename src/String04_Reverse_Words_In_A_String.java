/*
151.翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：
输入: "the sky is blue"
输出: "blue is sky the"
 */
/*
 * 解法四：时间复杂度 O(n)
 * 参考卡哥 c++ 代码的三步骤：先移除多余空格，再将整个字符串反转，最后把单词逐个反转
 * 有别于解法一 ：没有用 StringBuilder  实现，而是对 String 的 char[] 数组操作来实现以上三个步骤
 */
public class String04_Reverse_Words_In_A_String {
        //用 char[] 来实现 String 的 removeExtraSpaces，reverse 操作
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            //1.去除首尾以及中间多余空格
            chars = removeExtraSpaces(chars);
            //2.整个字符串反转
            reverse(chars, 0, chars.length - 1);
            //3.单词反转
            reverseEachWord(chars);
            return new String(chars);
        }

        //1.用 快慢指针 去除首尾以及中间多余空格，可参考数组元素移除的题解
        public char[] removeExtraSpaces(char[] chars) {
            int slow = 0;
            for (int fast = 0; fast < chars.length; fast++) {
                //先用 fast 移除所有空格
                if (chars[fast] != ' ') {
                    //在用 slow 加空格。 除第一个单词外，单词末尾要加空格
                    if (slow != 0)
                        chars[slow++] = ' ';
                    //fast 遇到空格或遍历到字符串末尾，就证明遍历完一个单词了
                    while (fast < chars.length && chars[fast] != ' ')
                        chars[slow++] = chars[fast++];
                }
            }
            //相当于 c++ 里的 resize()
            char[] newChars = new char[slow];
            System.arraycopy(chars, 0, newChars, 0, slow);
            return newChars;
        }

        //双指针实现指定范围内字符串反转，可参考字符串反转题解
        public void reverse(char[] chars, int left, int right) {
            if (right >= chars.length) {
                System.out.println("set a wrong right");
                return;
            }
            while (left < right) {
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left] ^= chars[right];
                left++;
                right--;
            }
        }

        //3.单词反转
        public void reverseEachWord(char[] chars) {
            int start = 0;
            //end <= s.length() 这里的 = ，是为了让 end 永远指向单词末尾后一个位置，这样 reverse 的实参更好设置
            for (int end = 0; end <= chars.length; end++) {
                // end 每次到单词末尾后的空格或串尾,开始反转单词
                if (end == chars.length || chars[end] == ' ') {
                    reverse(chars, start, end - 1);
                    start = end + 1;
                }
            }
        }
    }
