import java.util.*;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1_000_000_007;
        int[][] eng = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            eng[i][0] = efficiency[i];
            eng[i][1] = speed[i];
        }
        
        Arrays.sort(eng, (a, b) -> b[0] - a[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long speedSum = 0, maxPerf = 0;
        
        for (int[] e : eng) {
            if (pq.size() == k) {
                speedSum -= pq.poll();
            }
            
            pq.offer(e[1]);
            speedSum += e[1];
            maxPerf = Math.max(maxPerf, speedSum * e[0]);
        }
        
        return (int)(maxPerf % mod);
    }
}