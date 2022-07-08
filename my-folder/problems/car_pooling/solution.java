class Passenger {
    int startLocation;
    int endLocation;
    int number;
    public Passenger(int startLocation, int endLocation, int num) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.number = num;
    }
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Passenger[] passengers = new Passenger[trips.length];
        for(int i = 0; i < trips.length; i++) {
            passengers[i] = new Passenger(trips[i][1], trips[i][2], trips[i][0]);
        }
        Arrays.sort(passengers, (a, b) -> a.startLocation - b.startLocation);
        
        PriorityQueue<Passenger> pq = new PriorityQueue<>((a, b) -> a.endLocation - b.endLocation);
        
        for(Passenger passenger : passengers) {
            while(!pq.isEmpty() && passenger.startLocation >= pq.peek().endLocation) {
                capacity += pq.poll().number;
            }
            if(capacity < passenger.number) {
                return false;
            }
            pq.add(passenger);
            capacity -= passenger.number;
        }
        return true;
    }
}