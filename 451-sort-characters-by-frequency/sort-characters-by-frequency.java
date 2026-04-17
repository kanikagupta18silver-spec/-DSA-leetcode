import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();
            
            while(freq-- > 0){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}