class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        
        task(s);
        
        return s;
    }
    
    static void task(Stack<Integer> s) {
        if(s.size() == 1) return;
        
        int element = s.pop();
        
        task(s);
        
        Stack<Integer> stk = new Stack<>();
        
        while(!s.isEmpty() && s.peek() > element) {
            stk.push(s.pop());
        }
        
        s.push(element);
        
        while(!stk.isEmpty()) {
            s.push(stk.pop());
        }
    }
}