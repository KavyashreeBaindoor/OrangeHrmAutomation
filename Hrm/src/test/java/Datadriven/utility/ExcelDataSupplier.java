package Datadriven.utility;

import java.io.*;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
	
	
	@DataProvider(name="dp1")
	public String[][] dataSupplier() throws IOException {
			File f=new File("F:\\2024\\CapstoneProject\\Hrm\\src\\test\\java\\Datadriven\\TestData\\LoginData.xlsx");
			System.out.println(f.exists());
			//to read data from file --create input streams
			
			FileInputStream fis=new FileInputStream(f);
			//convert raw data to - excel workbook
			
			//xls
			//HSSFWorkbook
			
			//xslx
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheetAt(0);
		int noOfRows=sh.getPhysicalNumberOfRows();	//4
	//	System.out.println(sh.getLastRowNum());		//3 (0,1,2,3--index)
		
		int noOfColumns=sh.getRow(0).getLastCellNum();//2
		
		
		//row ==  0,1,2,3
		//cellno  -- 0,1,2,3
		
		
		String[][] data=new String[noOfRows-1][noOfColumns];
		
		
		
		for(int i=0;i<sh.getPhysicalNumberOfRows()-1;i++) {
				for(int j=0;j<noOfColumns;j++) {
					
					//System.out.println(sh.getRow(i).getCell(j).getStringCellValue());	//can get only String type
				DataFormatter df=new DataFormatter();
				//converts any type of data TO string/text type value and then further 
				//convert it to any type later as per ur req.
				//System.out.println(df.formatCellValue(sh.getRow(i).getCell(j)));	
				
				data[i][j]=df.formatCellValue(sh.getRow(i+1).getCell(j));
				
				
				
					
				}
			
		}
		
		
		
		wb.close();
		fis.close();
	        
	        

		for(String[] arr:data) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		return  data;
		

}
}