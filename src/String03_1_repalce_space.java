/*
题目：剑指Offer 05.替换空格
 */
public class String03_1_repalce_space {
    public String replaceSpace(String s){
        StringBuilder sb = new StringBuilder();
        //使用一个新的对象，复制 str，复制的过程对其判断，是空格则替换，否则直接复制，类似于数组复制
        // 使用 sb 逐个复制 s ，碰到空格则替换，否则直接复制
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
