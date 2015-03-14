package tools;
import java.util.List;


public class Tools {
	public static void print(List<List<Integer>> list){
		for(List<Integer> row: list){
			System.out.print("[");
			for(int i = 0; i < row.size(); i++){
				if(i == 0){
					System.out.print(row.get(i));
				}else{
					System.out.print(","+row.get(i));
				}
			}
			System.out.print("], ");
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
