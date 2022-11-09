import java.util.HashSet;
import java.util.Set;
/*
202. 快乐数
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
 */
public class HashTable03_happy_num {
    // 计算n每个位上的平方和
    private int sum(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        // HashSet:一个没有重复元素的集合
        Set<Integer> set = new HashSet<>();
        while (true) {
            // 计算n的各个位上的平方和
            int sumN = sum(n);
            // 判断是否为快乐数
            if (sumN == 1) return true;
            //若新计算的平方和在之前出现过，此时陷入循环，该数不是快乐数
            if (set.contains(sumN)) {
                return false;
            } else {
                // 将新的平方和添加到集合中
                set.add(sumN);
            }
            // 将当前结果再进行判断，去循环
            n = sumN;
        }
    }
}
