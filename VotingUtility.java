package exelutility;

import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VotingUtility {
	public static String getreaddata(String path,int rownum,int columnno ) {
		String value="";
		try {
			FileInputStream fis=new FileInputStream(path);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			value=sheet.getRow(rownum).getCell(columnno).getStringCellValue();
			
		
		} catch (Exception e) {
		System.err.println(" Issue in get read data "+e);
		}
		return value;
	}
	
	public void displaydetail() {
		System.out.println(" _______Candidate Detail______");
		System.out.println("| Name         : "+name+"     ");
		System.out.println("| fName        : "+fname+"    ");
		System.out.println("| Age          : "+age+"      ");
		if(choice==1) {
		System.out.println("| Mode of Vote : Aadhaar Card ");
		System.out.println("| Aadhaar No   : "+AdhaarNo+ "");
		System.out.println("|_____________________________");
		}
		else {
		System.out.println("| Mode of Vote : VOterID Card ");
		System.out.println("| VoterId      : "+VoterIdNo+"");
		System.out.println("|_____________________________");
		}
		
	}
	public void EvmMachine() {
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter your choice of candidate....");
		System.out.println("Congress party       :: Siddhart nath : press 1");
		System.out.println("Bhartiye Janta Party :: Lokesh Tiwari : press 2");
		System.out.println("Aam Admi Party       :: Sanjay Singh  : press 3");
		int pick=sc.nextInt();
		if(pick==1) {
			System.out.println("Congrats your vote is succefully goes to :: Congress Party");
		}
		else if(pick==2) {
			System.out.println("Congrats your vote is succefully goes to :: Bhartiye Janata Party");
		}
		else if (pick==3) {
			System.out.println("Congrats your vote is succefully goes to :: Aam Admi Party");
		}
		else {
			System.out.println("you have chosen ::NOTA");
		}
		displaydetail();
	}
	int choice;
	String AdhaarNo;
	String VoterIdNo;
	public void choice() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your choice");
		System.out.println("Press 1 for Aadhaar Verification");
		System.out.println("Press 2 for VoterID Verification");
		String path="C:\\Users\\91639\\eclipse-workspace\\newlaptop\\testdata\\javaTesting_demo.xlsx";
		try {
			
			choice=sc.nextInt();
			if(choice==1) {
				System.out.println("Enter your aadhar No");
				AdhaarNo=sc.next();
				boolean flag=false;
				try {
					System.out.print("Data Fetching.");
					Thread.sleep(1000);
					System.out.print(" .");
					Thread.sleep(1000);
					System.out.print(" .");
				} catch (Exception e) {
					System.out.println(e);
				}
				for(int i=0;i<12;i++) {
				if(AdhaarNo.equals(getreaddata(path,i,1))) {
					System.out.println("Congrats your database is present");
					flag=true;
					EvmMachine();
					
				}
				}
				if (flag==false) {
					System.out.println("you are not in my db");
				}
					
			}
			else if (choice==2) {
				System.out.println("Enter your VoterID No");
				 VoterIdNo=sc.next();
				boolean flag=false;
				try {
					System.out.print("Data Fetching.");
					Thread.sleep(1000);
					System.out.print(" .");
					Thread.sleep(1000);
					System.out.print(" .");
				} catch (Exception e) {
					System.out.println(e);
				}
				
				for(int i=0;i<12;i++) {
					if(VoterIdNo.equals(getreaddata(path,i,2))) {
						System.out.println("Congrats your database is present");
						flag=true;
						EvmMachine();
					}
					}
				if (flag==false) {
					System.out.println("you are not in my db");
				}
			}
			else {
				System.out.println("Press either 1 or 2 ");
				choice();
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input"+e);
			choice();
		}
		
		
	}
	String name,fname;
	public void filldetail() {
		Scanner sc=new Scanner(System.in);
		
		try {
			System.out.println("Please Enter your Name");
			name=sc.nextLine();
				
		} catch (InputMismatchException e) {
			System.out.println("Invalid input"+e);
			filldetail();
		}
		try {
			System.out.println("Please Enter your Father's Name");
			fname=sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input"+e);
			filldetail();
		}
		choice();
		
	}
	int age;
	public void getcondition() {
		System.out.println("what's your Age ?");
		Scanner sc=new Scanner(System.in);
		try {
			 age=sc.nextInt();
			try {
				if(age<18) {
					throw new Exception();
				}
				else {
					System.out.println("your age is valid");
					filldetail();
					
				}
			} catch (Exception e) {
			System.out.println("your age is not valid");
			getcondition();
			}
		} catch (Exception e) {
			System.out.println("Invalid input"+e);
			getcondition();
		}
		
		
	}
public void getdata() {
	Scanner sc=new Scanner(System.in);
	System.out.println("****Election Commission of BabaTesting****");
	System.out.println();
	System.out.println("Are you eligible to have your voting rights");
	getcondition();
	
}

	public static void main(String[] args) {
		
		VotingUtility ob=new VotingUtility();
		ob.getdata();
		
		

	}

}
