import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static char gradeLetter(double score) {
		
		char grade = 'A';
		if(score >= 70){
			grade = 'A';
		}else if(score >= 60){
			grade = 'B';
		}else if(score >= 50){
			grade = 'C';
		}else if(score >= 40){
			grade = 'D';
		}else{
			grade = 'F';
		}
		
		return grade;	
	}
	
	public static void main(String[] args) {
		
		String[] indexNumber = new String[15];
		int[] midsem = new int[15];
		int[] exams = new int[15];
		String index = "1002";
		int size = 0;		
		try {
			FileReader fr = new FileReader("C:/Documents/index.txt");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(fr);
			while(sc.hasNext()) {
				indexNumber[size++] = sc.next();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}	
		
		try {
			FileReader fr = new FileReader("C:/Documents/midsem.txt");
			Scanner sc = new Scanner(fr);
			for(int i = 0; i < midsem.length; i++) {
				midsem[i] = sc.nextInt();
			}
			
			sc.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}	
		try {
			FileReader fr = new FileReader("C:/Documents/exams.txt");
			Scanner sc = new Scanner(fr);
			for(int i = 0; i < exams.length; i++) {
				exams[i] = sc.nextInt();
			}
			
			sc.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}	
		double[] finalScores = new double [midsem.length];
		char[] grades = new char[midsem.length];
		double finalScore;
		double averageScore, sum = 0;
			for(int i = 0; i < midsem.length; i++){
				finalScore = ((midsem[i] * 30)/100.0) + ((exams[i] * 70) / 100.0);
				finalScores[i] = Math.round(finalScore);
				gradeLetter(Math.round(finalScore));
				grades[i] = gradeLetter(Math.round(finalScore));
				sum += finalScores[i];
			}
			averageScore = sum / finalScores.length;
			
			try {
				FileWriter fr = new FileWriter("C:/Documents/main.txt");
				BufferedWriter br = new BufferedWriter(fr);
				br.write("FINAL SCORES: " + Arrays.toString(finalScores) + "\n");
				br.write("GRADES: " + Arrays.toString(grades) + "\n");
				br.write("\nAVERAGE SCORE: " + averageScore + "\n");
//				Arrays.sort(finalScores);
				double maxScore = finalScores[finalScores.length - 1];
				double minScore = finalScores[0];
				br.write("\nMAXIMUM SCORE: " + maxScore + "\n");
				br.write("\nMINIMUM SCORE: " + minScore + "\n");
				br.write("INDEX NUMBER\tFINAL SCORES\tGRADES\n");
				
				int [] freq = new int [grades.length];  
			    int visited = -1;  
			    for(int i = 0; i < grades.length; i++){  
			        int count = 1;  
			        for(int j = i+1; j < grades.length; j++){  
			            if(grades[i] == grades[j]){  
			                count++;   
			                freq[j] = visited;  
			            }  
			        }  
			        if(freq[i] != visited)  
			            freq[i] = count;  
			    }  
			    br.write("---------------------------------------\n");  
			    br.write(" Grade | Frequency\n");  
			    br.write("---------------------------------------\n");  
			    for(int i = 0; i < freq.length; i++){  
			        if(freq[i] != visited)  
			            br.write("    " + grades[i] + "    |    " + freq[i] + "\n");  
			    }  
			    br.write("----------------------------------------\n");
			
				br.write("  " + "NAME\t\tFINALSCORE\tGRADES\n");
				for(int i = 0; i < midsem.length; i++) {
					br.write("  " + (index+indexNumber[i]) + "\t  " + finalScores[i] + "\t\t  " + grades[i] + "\n");
				}
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
			
	}
