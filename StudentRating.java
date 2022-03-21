import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class StudentRating {

//	FIND MAXIMUM VALUE 
	public static int maximumValue(int arr[]) {
		Arrays.sort(arr);
		return arr[arr.length - 1];
	}
	
//	FIND MINIMUM VALUE
	public static int minimumValue(int arr[]) {
		Arrays.sort(arr);
		return arr[0];
	}
	
//	FIND MEAN
	public static double meanValue(int arr[]) {
		double sum = 0, mean;
		for(int num : arr) {
			sum += num;
		}
		mean = sum / arr.length;
		return mean;
	}
	
//FIND MODE
	public static int modalValue(int arr[]) {
		int mode = 0, maxCount = 0;
		for(int num1 : arr) {
			int count = 0;
			for(int num2 : arr) { 
				if(num1 == num2)
					count++;
			}
			if(count > maxCount) {
				maxCount = count;
				mode = num1;
			}
		
		}
		return mode;
	}
	
//	MEDIAN
	public static double medianValue(int arr[]) {
		double median;
		Arrays.sort(arr);
		median = arr.length % 2 == 0 ? (arr[(arr.length / 2)] + arr[(arr.length / 2) - 1]) / 2.0 : arr[(int) Math.floor(arr.length / 2)];
		return median;
	}
	
//	STANDARD DEVIATION
	public static double standardDeviation(int arr[]) {
		double variance = 0, mean, sD;
		mean = meanValue(arr);
		for(int num : arr) {
			variance += Math.pow((num - mean), 2);
		}
		sD = Math.sqrt(variance / (arr.length));
		return sD;
	}
	public static void main(String[] args) {
		int [] rating = new int[20];
		int size = 0;
		File file = new File("C:/Documents/rating.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextInt()) {
				size++;
				sc.nextInt();
			}
			int[] array = new int[size]; 
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(file);
			for(int i = 0; i < array.length; i++) {
				array[i] = scan.nextInt();
				rating[i] = array[i];
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		try {
			FileWriter fr = new FileWriter("C:/Documents/studentRating.txt");
			BufferedWriter br = new BufferedWriter(fr);
			br.write("MAXIMUM VALUE = " + maximumValue(rating) + "\n");
			br.write("MINIMUM VALUE = " + minimumValue(rating) + "\n");
			br.write("MEAN VALUE = " + meanValue(rating) + "\n");
			br.write("MEDIAN = " + medianValue(rating) + "\n");
			br.write("MODE = " + modalValue(rating) + "\n");
			br.write("STANDARD DEVIATION VALUE = " + standardDeviation(rating) + "\n");
			
			int [] freq = new int [rating.length];  
	        int visited = -1;  
	        for(int i = 0; i < rating.length; i++){  
	            int count = 1;  
	            for(int j = i+1; j < rating.length; j++){  
	                if(rating[i] == rating[j]){  
	                    count++;   
	                    freq[j] = visited;  
	                }  
	            }  
	            if(freq[i] != visited)  
	                freq[i] = count;  
	        }  
	        //Displays the frequency of each element present in array  
	        br.write("---------------------------------------\n");  
	        br.write(" Element(x) | Frequency(f)\n");  
	        br.write("---------------------------------------\n"); 
	        for(int i = 0; i < freq.length; i++){  
	            if(freq[i] != visited)  
	                br.write("    " + rating[i] + "    |    " + freq[i] + "\n");  
	        }  
	        br.write("----------------------------------------\n"); 
			
			Arrays.sort(rating);
			br.write("SORTED ARRAY = " +  Arrays.toString(rating));
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	       
	}

}
