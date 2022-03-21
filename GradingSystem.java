
import java.io.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GradingSystem {

	public static void main(String[] args) {
		double examScore = 0, assessmentScore = 0, totalGrade, fees = 0;
		String printOut = "";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter student score: ");
		try {
			examScore = sc.nextDouble();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid... Input should be a number");
			return;
		}
		System.out.print("Enter student assessment: ");
		try {
			assessmentScore = sc.nextDouble();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid... Input should be a numeber");
			return;
		}
		System.out.print("Enter student fees paid: ");
		try {
			fees = sc.nextDouble();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid... Input should be a numeber");
			return;
		}
		totalGrade = examScore + assessmentScore;
		if(examScore >= 25 && assessmentScore >= 15) {
			if(fees < 100) {
				printOut = "You have been tagged as owing fees.";
			}
			else {
				printOut = "You will be issued a certificate";
			}
		}else if(totalGrade == 39 && fees < 100)
		{
			if(examScore == 25 && assessmentScore == 14 || examScore == 24 && assessmentScore == 15) {
				printOut = "You have been tagged as owing fees";
			}
		}else if(totalGrade == 39 && fees == 100)
		{
			if(examScore == 25 && assessmentScore == 14 || examScore == 24 && assessmentScore == 15) {
				printOut = "You are condoned";
			}
		}else if(examScore < 25 && assessmentScore < 15 && fees == 100) {
			printOut = "YOU FAILED IN BOTH REQUIREMENT U ARE REPEATED";
		}else if(examScore < 25 && fees == 100) {
			System.out.println("YOU PASSED IN YOUR ASSESSMENT BUT FAILED IN YOUR EXAM SCORE");
		}else {
			printOut = "YOU PASSED IN YOUR EXAM BUT FAILED IN YOUR ASSESSMENT";
		}
		
		
		try {
			FileWriter fr = new FileWriter("C:/Documents/gradingSystem.txt");
			BufferedWriter br = new BufferedWriter(fr);
			br.write("Exams Score = " + examScore);
			br.newLine();
			br.write("Assessment Score = " + assessmentScore);
			br.newLine();
			br.write("Total Score = " + totalGrade);
			br.newLine();
			br.write("Fees Paid = " + fees);
			br.newLine();
			br.write(printOut);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
