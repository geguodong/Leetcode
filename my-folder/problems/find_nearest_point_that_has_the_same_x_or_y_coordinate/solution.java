class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index=-1;        
        int Mandist=Integer. MAX_VALUE;
        for(int i=0;i<points.length;i++){
            if(x==points[i][0] || y==points[i][1]){                
                int dist=Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);                
                if(dist<Mandist ){
                 index=i;                                  
                 Mandist=dist;                    
                }                
            }            
        }    
        return index;    
    }
}