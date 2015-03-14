package greedy;

public class GasStation {
	/**
	 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
	
	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
	You begin the journey with an empty tank at one of the gas stations.
	
	Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
	
	Note:
	The solution is guaranteed to be unique.
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length < 1) return 0;
        int start = 0, g = 0, p = 0, step = gas.length;
        while(step > 0){
        	g = g + gas[p] - cost[p];
        	if(p == gas.length - 1) p = 0;
        	else p++;
        	if(g < 0){
        		if(start >= p) return -1;
        		start = p;
        		g = 0;
        		step = gas.length;
        	}else{
        		step--;
        	}
        }
        return start;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GasStation s = new GasStation();
		int[] g = {3,2,5,1};
		int[] c = {3,4,2,3};
		System.out.println(s.canCompleteCircuit(g, c));
		int[] a = {4};
		int[] b = {5};
		System.out.println(s.canCompleteCircuit(a, b));
	}

}
