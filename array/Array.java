package array;

import java.util.List;

public class Array {
	public static void print(int[] array){
		if(array == null){
			System.out.println("wrong input: null!");
			return;
		}
		for(int i = 0; i< array.length; i++){
			System.out.print("-->" + array[i]);
		}
		System.out.println();
	}
	public static void print(char[][] matrix){
		if(matrix == null){
			System.out.println("null matrix!");
			return;
		}
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; matrix[i] != null && j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
	}
	public static void print(int[][] matrix){
		if(matrix == null){
			System.out.println("null matrix!");
			return;
		}
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; matrix[i] != null && j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
	}
	public static void print(List<Integer> list){
		if(list == null){
			System.out.println("list == null");
			return;
		}
		for(int a: list){
			System.out.print("->"+a);
		}
		System.out.println();
	}
	public static void print2(List<List<Integer>> list){
		print2(list, "->", "-->");
	}
	public static void print2(List<List<Integer>> list, String separator){
		print2(list, separator, "");
	}
	public static void print2(List<List<Integer>> list, String separator, String head){
		if(list == null){
			System.out.println("list == null");
			return;
		}
		System.out.println(head);
		for(List<Integer> l: list){
			boolean begin = true;
			for(int a: l){
				if(begin){
					System.out.print(a);
					begin = false;
				}else{
					System.out.print(separator+a);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static <T> void print(T[] array){
		if(array == null){
			System.out.println("wrong input: null!");
			return;
		}
		for(int i = 0; i< array.length; i++){
			System.out.print("-->" + array[i]);
		}
		System.out.println();
	}
	public <T,M,N> void getTType(T t,M m,N n){  
        /* 
         * 传入int,long ,double等基本类型时，自动打包机制 
         * 会将基本类型包装成相应的对象 
         */  
        System.out.println(t.getClass().getName());  
        System.out.println(m.getClass().getName());  
        System.out.println(n.getClass().getName());  
    }  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array s = new Array();
		Integer[] a = {1,2,3,4,5,6,7,8,9};
		int[] b = {1,2,3,4,5,6,7,8,9};
		s.getTType("", 1, 1.0);
		s.print(a);
		Array.print(b);
	}

}
