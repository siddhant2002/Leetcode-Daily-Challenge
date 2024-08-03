class Solution {
    public static void print_divisors(int n) {
        // code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                list.add(i);
                if(i * i != n) {
                    list.add(n / i);
                }
            }
        }
        
        Collections.sort(list);
        
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}