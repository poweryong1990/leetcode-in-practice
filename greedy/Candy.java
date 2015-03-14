package greedy;

public class Candy {
	/**
	 * There are N children standing in a line. Each child is assigned a rating value.
	
	You are giving candies to these children subjected to the following requirements:
	
	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give?
	 */
	public int candy(int[] ratings) {
		if(ratings == null || ratings.length < 1) return 0;
		if(ratings.length == 1) return 1;
        int sum = 0, p = 0, last = 1;
        for(int i = 0; i < ratings.length - 1; i++){
        	if(ratings[i] <= ratings[i +1]){
        		if(i == p){
        			if(i == 0 || ratings[i] == ratings[i-1]){
        				last = 1;
        			}else{
        				last += 1;
        			}
        			sum += last;
        		}else{
        			int t = i - p + 1;
        			sum += (t + 1) * t / 2;
        			if(p > 0 && ratings[p - 1] < ratings[p] && t <= last){
        				sum += last - t + 1;
        			}
        			last = 1;
        		}
        		p = i + 1;
        	}
        }
        if(p <= ratings.length - 1){
        	if(p == ratings.length - 1){
        		if(ratings[p] == ratings[p-1]){
        			sum += 1;
        		}else{
        			sum += last + 1;
        		}
        	}else{
        		int t = ratings.length - p;
        		sum += (t + 1) * t / 2;
        		if(p > 0 && ratings[p - 1] < ratings[p] && t <= last){
    				sum += last - t + 1;
    			}
        	}
        }
        return sum;
    }
	public int candy2(int[] ratings) {
		if(ratings == null || ratings.length < 1) return 0;
		int[] candys = new int[ratings.length];
		for(int i = 1; i < ratings.length; i++){
			if(ratings[i] > ratings[i-1]){
				candys[i] = candys[i-1] + 1;
			}
		}
		for(int i = ratings.length -2; i >= 0; i--){
			if(ratings[i] > ratings[i +1] && candys[i] <= candys[i +1]){
				candys[i] = candys[i +1] + 1;
			}
		}
		int sum = ratings.length;
		for(int a: candys){
			sum += a;
		}
		return sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candy s = new Candy();

		int[] a = {3,5,4,1,2,3,4,2,1};
		int[] b = {1,2,2};
		int[] c = {1,3,5};
		System.out.println(s.candy(a) + ", " + s.candy2(a));
		System.out.println(s.candy(b) + ", " + s.candy2(b));
		System.out.println(s.candy(c) + ", " + s.candy2(c));
	}

}
