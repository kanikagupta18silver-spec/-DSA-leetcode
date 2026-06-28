class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length() ;
        int[] count = new int[26] ;
        for(int i = 0 ; i < n ; i++)
        {
            char ch = s.charAt(i) ;
            count[ch-'a'] = i ;
        }

        int i = 0 ;
        ArrayList<Integer> ans = new ArrayList<>() ;
        while(i < n)
        {
            char ch = s.charAt(i) ;
            int start = i ;
            int end = count[ch-'a'] ;
            while(i < end)
            {
                end = Math.max(count[s.charAt(i)-'a'],end)  ;
                i++ ;
            }
            ans.add(end-start+1) ;
            i++ ;
        }
        return ans ;
    }
}