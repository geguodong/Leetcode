
class BrowserHistory {
    
    LinkedList <String> urls;
    int curr;
    public BrowserHistory(String homepage) {
        urls = new LinkedList<String>();
        urls.add(homepage);
        curr = 0;       
    }
    
    public void visit(String url) {
        for(int i = urls.size() - 1; i > curr; --i) {
            urls.removeLast();
        }
        urls.addLast(url);
        curr++;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return urls.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(urls.size() - 1, curr + steps);
        return urls.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */