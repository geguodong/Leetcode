

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

class CustomStack {
    int[] arr;
    int top;
    public CustomStack(int maxSize) {
        arr=new int[maxSize];
        top=-1;
    }
    
    public void push(int x) {
        if(top+1<arr.length){
            top++;
            arr[top]=x;
        }
    }
    
    public int pop() {
        int c;
        if(top>=0 && top<arr.length){
            c=arr[top];
            top=top-1;
            return c;            
        }else{
            return -1;
        }
        
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k && i<=top;i++)
            arr[i]+=val;
    }
}