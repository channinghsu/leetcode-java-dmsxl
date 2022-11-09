/*
454. 四数相加 II
给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
                                 0 <= i, j, k, l < n
                                 nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */

/*
首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
最后返回统计值 count 就可以了
 */

import java.util.HashMap;
import java.util.Map;

public class HashTable05_4_Sum_II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();//key:a+b的数值，value:a+b数值出现的次数
        int temp;
        int res = 0;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        //再遍历剩下两个数组，找到如果 0-temp 在map中出现过的话，就把map中key对应的value，也就是出现次数统计出来。
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }
        return res;
    }
}
