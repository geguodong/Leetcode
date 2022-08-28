class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> p=new PriorityQueue<Integer>();
        int ans=0;
        int i=0;
        for(int d=1;d<=100001;d++)
        {
            while(i<n && events[i][0]==d)
            {
                p.add(events[i][1]);
                i++;
            }
            while(!p.isEmpty() && p.peek()<d)//remove all whose endday is smaller than curday(bcz at day 5 we can't proceed with endday 4)
                p.poll();
            
            if(!p.isEmpty())// we have to remove that element whose endday is small
            {
                p.poll();
                ans++;
            }
        }
        return ans;
    }
}