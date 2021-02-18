import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.junit.Assert;

public class LFUCache {

    private int min;
    private int capacity;
    private Map<Integer, Integer> cacheMap;
    private Map<Integer, Integer> freqMap;
    private Map<Integer, LinkedHashSet<Integer>> freqBucketList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        freqMap = new HashMap<>();
        freqBucketList = new HashMap<>();
        freqBucketList.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;

        // update freqMap with latest count
        int freq = freqMap.get(key);
        freqMap.put(key, freq + 1);

        freqBucketList.get(freq).remove(key);

        // update min value
        if (freq == min && freqBucketList.get(freq).size() == 0) {
            min++;
        }

        // now move item to next bucket
        if (!freqBucketList.containsKey(freq + 1)) {
            freqBucketList.put(freq + 1, new LinkedHashSet<>());
        }
        freqBucketList.get(freq + 1).add(key);

        // finally return value from cache
        return cacheMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            get(key);
            return;
        }
        if (cacheMap.size() >= capacity) {
            int evictItemKey = freqBucketList.get(min).iterator().next();
            freqBucketList.get(min).remove(evictItemKey);
            cacheMap.remove(evictItemKey);
        }
        cacheMap.put(key, value);
        freqMap.put(key, 1);
        freqBucketList.get(1).add(key);
        min = 1;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3, 3);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(3)); // not found, was evicted in the last put
        Assert.assertEquals(4, cache.get(4));
    }

}
