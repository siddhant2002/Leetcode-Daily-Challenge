class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int left = 0, right = 0, n = s.length();
        
        int ans = -1;
        
        Map<Character, Integer> map = new HashMap<>();
        
        while(right < n) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            if(map.size() == k) {
                ans = Math.max(ans, right - left + 1);
            }
            else if(map.size() > k) {
                while(map.size() > k) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if(map.get(s.charAt(left)) == 0) {
                        map.remove(s.charAt(left));
                    }
                    
                    left++;
                }
                
                ans = Math.max(ans, right - left + 1);
            } 
            
            right++;
        }
        
        return ans;
    }
}