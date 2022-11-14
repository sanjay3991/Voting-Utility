package exelutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Voting_utility_Testdata 
{    String name;
     String fname; 
     int  age;
     String value;
     int choice;

	 String voterid;
	 String Adhar;

	public static String  exceldada(String path, int row,int cell)
	{
		String value="";
		try {
			FileInputStream fis= new FileInputStream(path);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheet= wb.getSheetAt(0);
					value=sheet.getRow(row).getCell(cell).getStringCellValue();
		} catch (Exception e) {
			System.out.println("issue "+e);
		}
		
		return value;
		
		}
	
	
	public  void getnamedata()  //Remove static
	 
	{ Scanner sc= new Scanner(System.in);
	String path="C:\\Users\\91639\\eclipse-workspace\\newlaptop\\testdata\\javaTesting_demo.xlsx";
	try {
		System.out.println("please enter name");
		name=sc.next();
		System.out.println("please enter father name");
		fname=sc.next();
		System.out.println("please enter age");
		age=sc.nextInt();
		if(age<18)
		{
			System.out.println("age is not valid");
			getnamedata();
		}
		else
		{
			System.out.println("please enter choice for vote mode");
			System.out.println("Prese 1 for Adhar\n"+"Press 2 for voterid\n");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
			{
				System.out.println("please enter Adhar number");
				 Adhar=sc.next();
				
				 //choice = 0;
				 boolean flag=false;
				for(int i=0; i<=10;i++)
				{
				
				if(Adhar.equals(exceldada(path,i,1)))
				{
					System.out.println("congrats your db is present");
					flag=true;
					{System.out.println("Prese 1 for AAP\n Press 2 for BJP\n Press 3 for congrss\n");
					int pick=sc.nextInt();
						switch(pick)
						{
						case 1:
						{
							System.out.println("congrats your vote is successfully to AAP party");
							break;
						}
						case 2:
						{
							System.out.println("congrats your vote is successfully to BJP party");
							break;
						}
						case 3:
						{
							System.out.println("congrats your vote is successfully to Congres party");
							break;
						}
						}
					}
					
					
				}
				}
				if(flag==false){
					System.out.println("your data is not present");
					getnamedata();
				}
				break;
			}
			
				
				
				
				
				
				
				
				
				
				
				
				
				
			case 2:
			{
				System.out.println("please enter Voter number");
				 voterid=sc.next();
				
				 //choice = 0;
				 boolean flag=false;
				for(int i=0; i<=10;i++)
				{
				
				if(voterid.equals(exceldada(path,i,2)))
				{
					System.out.println("congrats your db is present");
					flag=true;
					{System.out.println("Prese 1 for AAP\n Press 2 for BJP\n Press 3 for congrss\n");
					int pick=sc.nextInt();
						switch(pick)
						{
						case 1:
						{
							System.out.println("congrats your vote is successfully to AAP party");
							break;
						}
						case 2:
						{
							System.out.println("congrats your vote is successfully to BJP party");
							break;
						}
						case 3:
						{
							System.out.println("congrats your vote is successfully to Congres party");
							break;
						}
						}
					}
					
					
				}
				}
				if(flag==false){
					System.out.println("your data is not present");
					getnamedata();
				}
				break;
			}
			
			
		
		
	}
		System.out.println(".........................Candidate data..................");
		System.out.println("----------------------------------------------------------");
		System.out.println("    Name              " +  name );
		System.out.println("    father Name              " +  fname );
		System.out.println("    Age              " +  age );
		if(choice==2)
		{
		System.out.println("    voterid              " +  voterid );
		}
		if(choice==1) {
		System.out.println("    adhar id               " +  Adhar);
		}
	}
	}
		catch (Exception e) 
		{
		System.out.println(e);
		getnamedata();
	}
		
		
		
	}
	
	public static void main(String[] args)
	{
		Voting_utility_Testdata ob=new Voting_utility_Testdata();
		
		ob.getnamedata();
		
	}
}
