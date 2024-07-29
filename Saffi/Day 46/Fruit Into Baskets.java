class Solution {
    public static int totalFruits(Integer[] arr) {
        int left = 0, right = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        
        while(right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            if(map.size() <= 2) {
                int sum = 0;
                for(int key : map.keySet()) {
                    sum += map.get(key);
                }
                
                count = Math.max(count, sum);
            }
            else {
                while(map.size() > 2) {
                    map.put(arr[left], map.get(arr[left]) - 1);
                    
                    if(map.get(arr[left]) == 0) {
                        map.remove(arr[left]);
                    }
                    
                    left++;
                }
            }
            
            right++;
        }
        
        return count;
    }
}