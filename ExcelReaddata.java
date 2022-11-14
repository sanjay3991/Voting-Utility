package exelutility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaddata {
	public static String getreaddata(String path,int rownum,int columnno ) {
		String value="";
		try {
			FileInputStream fis=new FileInputStream(path);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			value=sheet.getRow(rownum).getCell(columnno).getStringCellValue();
			
		
		} catch (Exception e) {
		System.err.println(" Issue in get read data "+e );
		}
		return value;
	}
public static void main(String[] args) {
	String path="C:\\Users\\91639\\eclipse-workspace\\newlaptop\\testdata\\javaTesting_demo.xlsx";
	
	for(int i=0;i<12;i++) {
		String data=getreaddata(path,i,1);
		System.out.println(data);
		
	}
	System.out.println();
	System.out.println();
	for(int i=0;i<3;i++) {
		String data=getreaddata(path,2,i);
		System.out.print(data+" ");
		
	}
}
}
