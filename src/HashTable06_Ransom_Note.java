/*
383. 赎金信
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
如果可以，返回 true ；否则返回 false 。
magazine 中的每个字符只能在 ransomNote 中使用一次。
输入：ransomNote = "a", magazine = "b"
输出：false
输入：ransomNote = "aa", magazine = "aab"
输出：true
 */

public class HashTable06_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        // record数组存放26个小写字母
        int[] record = new int[26];
        // 在数组中记录magazine每个字符的个数
        for(char c : magazine.toCharArray()){
            record[c - 'a']++;
        }
        // 在数组中减去ransomNote中出现的字符
        for (char c: ransomNote.toCharArray()){
            record[c - 'a']--;
        }
        // 若数组中有元素小于零，说明ransomNote 能不能由 magazine 里面的字符构成
        for (int i : record) {
            if(record[i] < 0) return false;
        }
        return true;
    }
}
