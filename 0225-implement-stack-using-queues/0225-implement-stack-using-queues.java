class MyStack {
    Queue<Integer> queue=new LinkedList<>();
    int size;
    public MyStack() {
        size=0;
    }
    
    public void push(int x) {
        size=queue.size();
        queue.add(x);
        for(int i=0;i<size;i++)
        {
            queue.add(queue.peek());
            queue.poll();
        }
    }
    
    public int pop() {
        int x=queue.poll();
        return x;
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */