import java.util.HashSet;
import java.util.Set;

/*
349. 两个数组的交集
    给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
    输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class HashTable03_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();// 存放结果，之所以用set是为了给结果集去重
        /*
        直接使用set 不仅占用空间比数组大，而且速度要比数组慢，set把数值映射到key上都要做hash计算的。所以把set换为数组
        Set<Integer> result1 = new HashSet<>();
        for (int i : nums1) {result1.add(i);}
        */
        int[] nums = new int[1001];
        for (int i : nums1) {
            nums[i]++;
        }
        // 若nums2中包含nums1中的数，则添加到result中
        for (int i : nums2) {
            if (nums[i] >= 1) {
                result.add(i);
            }
        }
        // HashSet To Int Array
        return result.stream().mapToInt(x -> x).toArray();
    }
}
