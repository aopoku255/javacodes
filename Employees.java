import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Employees {
	public static void main(String[] args) {
		String[] names = new String[15];
		int[] hours = new int[15];
		int[] children = new int[15];
		double incTax = 0, NHIL = 0, sum = 0, disTax = 0, grossPay = 0, totalDed = 0, netPay = 0, totalNetPay = 0, averageNetPay = 0;
		int getFund = 0;
		double[] net = new double[names.length];
		double[] totalNet = new double[names.length];
		double[] gross = new double[names.length];
		double[] income = new double[names.length];
		double[] nhil = new double[names.length];
		double[] district = new double[names.length];
		double[] deductions = new double[names.length];	
		try {
			FileReader file = new FileReader("C:/Documents/employees.txt");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
			for(int i = 0; i < names.length; i++) {
				names[i] = sc.next();
			}
		}
		catch(Exception e) {
			System.out.println("File Not Fouund!!!");
		}
		
		try {
			FileReader file = new FileReader("C:/Documents/hours.txt");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
			for(int i = 0; i < hours.length; i++) {
				hours[i] = sc.nextInt();
			}
		}
		catch(Exception e) {
			System.out.println("File Not Fouund!!!");
		}
		
		try {
			FileReader file = new FileReader("C:/Documents/children.txt");
			Scanner sc = new Scanner(file);
			for(int i = 0; i < children.length; i++) {
				children[i] = sc.nextInt();
			}
		}
		catch(Exception e) {
			System.out.println("File Not Fouund!!!");
		}
		
		System.out.println("NAME \t   GROSS PAY");
		for(byte i = 0; i <names.length; i++){
			switch(names[i]){
				case "John":
				case "Rose":
				case "Cynthia":
				case "George":
				case "Emmanuel":
				case "Stephen":
				case "Alfred":
					if(hours[i] > 40){
						grossPay = (50 * 40) + (( 1.5 * 50) * (hours[i] - 40));	
					}
					else{
						grossPay = 50 * hours[i];
					}
					break;
				default:
					if(hours[i] > 40){
						grossPay = ((35 * 40) + (1.25 * 35) * (hours[i] - 40));
					}
					else{
						grossPay = 35 * hours[i];
					}
			}
			gross[i] = grossPay;
			
			if(children[i] > 3){
				getFund = children[i] - 3;
			}else{
				getFund = 0;
			}
			incTax = gross[i] * 0.15;
			income[i] = incTax;
			NHIL = gross[i] * 0.01;
			nhil[i] = NHIL;
			disTax = gross[i] * 0.03;
			district[i] = disTax;
			deductions[i] = income[i] + nhil[i] + district[i] + getFund;
			totalDed += deductions[i];
			netPay = gross[i] - (income[i] + nhil[i] + district[i]);
			net[i] = netPay;
			sum += net[i];
			
			totalNetPay = gross[i] - deductions[i];
			totalNet[i] = totalNetPay;
			System.out.println(names[i] + "\t    " + gross[i]);
		}
		averageNetPay = sum / names.length;
		System.out.println();
		
		System.out.println("NAME\t     DEDUCTIONS");
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "\t     " + deductions[i]);
		}
		System.out.println("\nTOTAL DEDUCTIONS: " + totalDed + "\n");
		System.out.println("NAME\t     NET PAY");
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "\t     " + net[i]);
		}
		System.out.println();
		System.out.println("NAME\t    NET PAY PAID");
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "\t     " + totalNet[i]);
		}
		System.out.println("\nAVERAGE NET PAY: " + averageNetPay);
		
	}
}