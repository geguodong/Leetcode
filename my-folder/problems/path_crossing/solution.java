class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        visited.add(x + "_" + y);

        for (int i = 0; i < path.length() ;i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                x++;
            } else if (c == 'S') {
                x--;
            } else if ( c == 'E') {
                y++;
            } else {
                y--;
            }
            String s = x + "_" + y;
            if (visited.contains(s)) {
                return true;
            }
            visited.add(s);
        }
        return false;
    }
}