package leetcode.topcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 *  - LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 *  - int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *  - void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 *    如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，
 *    则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @url: https://leetcode.cn/problems/lru-cache/
 * @Date: 2022/10/2
 * @Author: Zirui Wang
 */

/**
 * 执行用时：40 ms, 在所有 Java 提交中击败了97.30%的用户
 * 内存消耗：108.1 MB, 在所有 Java 提交中击败了91.58%的用户
 */
public class LRUCache_3_146 extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCache_3_146(int capacity){
        super(capacity+1, 1, true);
        this.capacity = capacity;
    }
    public int get(int key){
        Integer k = super.get(key);
        return k == null ? -1 : k;
    }
    public void put(int key, int value){
        super.put(key, value);
//        if(containsKey(key)){
//            super.put(key, value);
//            return;
//        }
//        if(size+1 <= capacity){
//            super.put(key, value);
//            size++;
//            return;
//        }
//        size++;
//        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

class TestLRUCache{
    public static void main(String[] args) {
        LRUCache_3_146 lru = new LRUCache_3_146(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.get(2);
        lru.put(4,4);
        lru.forEach((k, v) -> System.out.println(k + "---" + v));
    }
}
