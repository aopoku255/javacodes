import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class ShopsOutlet {

	public static void main(String[] args) {
		int totalHSBMS = 0, totalMBMS = 0, firstMonths = 0, secMonths = 0, thirdMonths = 0, firstQuatHSBMS = 0, secQuatHSBMS = 0, thirdQuatHSBMS = 0, forthQuatHSBMS = 0, firstQuatMBMS = 0, secQuatMBMS = 0, thirdQuatMBMS = 0, forthQuatMBMS = 0;
		int[][] HSBMS = new int[4][3];
		int[][] MBMS = new int[4][3];
		try {
			FileReader file = new FileReader("C:/Documents/highStreet.txt");
			Scanner sc = new Scanner(file);
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 3; j++) { 
						HSBMS[i][j] = sc.nextInt();
				}
			}
			sc.close();
		}
		catch(Exception e) {
			System.out.println("File Not Found!!!");
		}
		
		try {
			FileReader file = new FileReader("C:/Documents/MBMS.txt");
			Scanner sc = new Scanner(file);
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 3; j++) {
						MBMS[i][j] = sc.nextInt();
				}
			}
			
			sc.close();
		}
		catch(Exception e) {
			System.out.println("File Not Found!!!");
		}
		
//		RESPECTIVE MONTHLY COMBINED SALES FOR THE TWO SHOPS
		for(int i = 0; i < HSBMS.length; i++)
		{
			firstMonths += HSBMS[i][0] + MBMS[i][0];
			secMonths += HSBMS[i][1] + MBMS[i][1];
			thirdMonths += HSBMS[i][2] + MBMS[i][2];
		}
		
//		RESPECTIVE QUATERLY SALES FIGURES
		for(int i = 0; i < 3; i++)
		{
//			RESPECTIVE QUATERLY SALES FOR HIGH STREET BRANCH
			firstQuatHSBMS += HSBMS[0][i];
			secQuatHSBMS += HSBMS[1][i];
			thirdQuatHSBMS += HSBMS[2][i];
			forthQuatHSBMS += HSBMS[3][i];
//			RESPECTIVE QUATERLY SALES FOR MALL BRANCH
			firstQuatMBMS += MBMS[0][i];
			secQuatMBMS += MBMS[1][i];
			thirdQuatMBMS += HSBMS[2][i];
			forthQuatMBMS += HSBMS[3][i];
		}
		
//		RESPECTIVE ANNUAL SALES FOR HIGH STREET BRANCH
		for(int[] sales : HSBMS) 
		{
			for(int sale : sales) 
			{
				totalHSBMS += sale;
			}
		}
		
//		RESPECTIVE ANNUAL SALES FOR MALL BRANCH
		for(int[] sales : MBMS)
		{
			for(int sale : sales) 
			{
				totalMBMS += sale;
			}
		}

//		GRAND ANNUAL COMBINED TOTAL SALES
		int grandAnnual = totalHSBMS + totalMBMS;
		
		try {
			FileWriter fr = new FileWriter("C:/Documents/shops.txt");
			BufferedWriter br = new BufferedWriter(fr);
			br.write("RESPECTIVE MONTLY COMBINED SALES\n");
			br.write("MONTH 1\t\tMONTH 2\t\tMONTH 3\n" + firstMonths + "\t\t" + secMonths + "\t\t" + thirdMonths + "\n");
			br.write("QUATERLY SALES FOR HIGH STREET BRANCH\n\nQuarter\t\tSales\n");
			br.write("QUARTER 1\t" + firstQuatHSBMS + "\nQUARTER 2\t" + secQuatHSBMS + "\nQUARTER 3\t" + thirdQuatHSBMS + "\nQUARTER 4\t" + forthQuatHSBMS + "\n");
			br.write("QUATERLY SALES FOR MALL BRANCH\n\nQuarter\t\tSales\n");
			br.write("QUARTER 1\t" + firstQuatMBMS + "\nQUARTER 2\t" + secQuatMBMS + "\nQUARTER 3\t" + thirdQuatMBMS + "\nQUARTER 4\t" + forthQuatMBMS + "\n");
			br.write("RESPECTIVE ANNUAL SALES FOR THE TWO SHOPS\n");
			br.write("HIGH STREET BRANCH: " + totalHSBMS + "\n");
			br.write("MALL BRANCH: " + totalMBMS);
			br.write("\nGRAND TOTAL SALES: " + grandAnnual);
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
