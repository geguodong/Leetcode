class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] seen = new boolean[n + 1];
        dfs(res, n, 0, seen);
        return res;
    }
    
    private boolean dfs(int[] res, int n, int idx, boolean[] seen) {
        if (res.length == idx) {
            return true;
        }
        
        if (res[idx] > 0) {
            return dfs(res, n, idx + 1, seen);
        }
        
        for (int i = n; i > 0; i--) {
            if (seen[i])
                continue;
            
            if (i == 1 || (idx + i < res.length && res[idx + i] == 0)) {
                seen[i] = true;
                res[idx] = i;
                if (i > 1)
                    res[idx + i] = i;
                
                if (dfs(res, n, idx + 1, seen))
                    return true;
                
                seen[i] = false;
                res[idx] = 0;
                if (i > 1)
                   res[idx + i] = 0; 
            }
        }
        
        return false;
    }
}