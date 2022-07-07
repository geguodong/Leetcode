// Sort by end position and compare ETA
// O(NlogN) O(n)
class Car {
    public double position, eta;
    public Car(double position, double eta) { 
        this.position = position;
        this.eta = eta; // ETA is remaining time to reach the target. ( s = vt, hence t = s/v)
    }
}

// Sort from end position and compare time
// O(Nlogn) O(n)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length, fleets = 0;
        
        // Create Car instances so that they can be sorted....
        Car[] cars = new Car[N];
        
        // Create car instances so that we can group position and eta and sort them
        for(int i=0; i < N; i++) 
            // ETA is remaining time to reach the target. ( s = vt , hence t = s/v)
            cars[i] = new Car( 
                    (double) position[i], 
                    (double) (target - position[i]) / speed[i] 
            ) ;
        
        // Sort by starting position in descending order. 
        // Cars closer to target will reach faster
        // The car which is closest to target will always leed the fleet even if there is some car with higher speed behind. 
        // Cars with higher speed will match the speed of the leader of the fleet.  
        // So sorting in descending order of position ( or ascending order of ETA )
        Arrays.sort(cars, (a,b) -> Double.compare(b.position, a.position) );
        
        double currentSlowestETA = 0; // Current slowest ETA holds the slower most car which can't catch up anyone and will definitely form it's own fleet.

        for (Car car: cars) {
            
            // If ETA of any cut is slower than current ETA then definitely this car will not collide with current slowest car and lead a fleet
            if (car.eta > currentSlowestETA) {
                currentSlowestETA = car.eta;
                fleets++;
            }
            
            // if ETA is <= currentSlowestETA then this car will catch up with the fleet lead by currentSlowestETA
        }
        
        return fleets;
    }
}