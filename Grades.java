import java.io.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Grades {

	public static void main(String[] args) {
		double marks, fees;
		String text = "YOU FAILED";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter student's marks: ");
		try {
			marks = sc.nextDouble();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid... Input should be a numeber");
			return;
		}
		System.out.print("Enter student's fees: ");
		try {
			fees = sc.nextDouble();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid... Input should be a numeber");
			return;
		}
		if(fees == 100) {
			if(marks >= 70) {
				text = "A - You will be issued a certificate.";
			}
			else if(marks >= 60) {
				text = "B - You will be issuid a certificate.";
			}
			else if(marks >= 50) {
				text = "C - You will be issuid a certificate.";
			}
			else if(marks >= 40) {
				text = "D - You will be issuid a certificate.";
			}
			else if(marks >= 39) {
				text = "F - YOU ARE CONDONED";
			}
			else {
				text = "YOU FAILED";
			}
		}
		else {
			text = "YOU HAVE BEEN TAGGED AS OWING FEES.";
		}
		
		try {
			FileWriter fr = new FileWriter("C:/Documents/grades.txt");
			BufferedWriter br = new BufferedWriter (fr);
			br.write("Marks = " + marks);
			br.newLine();
			br.write("Fees Paid = " + fees);
			br.newLine();
			br.write(text);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
