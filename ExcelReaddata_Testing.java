package exelutility;

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaddata_Testing {
	public static ArrayList<String> getreaddata() {
		ArrayList<String>TestData=new ArrayList<String>();
		
		String path="C:\\Users\\91639\\eclipse-workspace\\new_automation\\testdata\\javaTesting_demo.xlsx";
		String value="";
		try {
			FileInputStream fis=new FileInputStream(path);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(1);
			for(int i=1;i<=10;i++) {
				for (int j=0;j<4;j++) {
			value=sheet.getRow(i).getCell(j).getStringCellValue();
				TestData.add(value);
				}
			}
			
			
		
		} catch (Exception e) {
		System.err.println(" Issue in get read data "+e );
		}
		return TestData ;
	}
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("insert no of data to test");
	int choice=sc.nextInt();
	ArrayList<String> TestData=getreaddata();
	for (int i=0;i<4*choice;i++) {
		System.out.println(TestData.get(i));
	}
	}
}
