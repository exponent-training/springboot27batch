package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataWriteInExcelfileExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataWriteInExcelfileExampleApplication.class, args);
		
		//Create Blank Workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//Create A blank Sheet
		XSSFSheet sheet = workbook.createSheet("Emp Data");
		
		Map<String, Object[]> map = new HashMap<>();
		map.put("1", new Object[] {"ID", "NAME", "ADDRESS"});
		map.put("2", new Object[] {1, "Abc", "Pune"});
		map.put("3", new Object[] {2, "Pqr", "Mumbai"});
		map.put("4", new Object[] {3, "Lmn", "Delhi"});
		map.put("5", new Object[] {4, "Xyz", "Banglore"});
		map.put("6", new Object[] {5, "Kpl", "Nashik"});
		
		
		Set<String> keySet = map.keySet();
		int rownum = 0;
		for(String key : keySet) {
			
			Row row = sheet.createRow(rownum++);
			Object[] objArr = map.get(key);
			
			int cellnum=0;
					
			  for(Object obj : objArr) {
				  
				  Cell cell = row.createCell(cellnum++);
				  
				  if(obj instanceof String) {
					  cell.setCellValue((String)obj);
				  }
					  else if(obj instanceof Integer) {
						  cell.setCellValue((Integer)obj);
				  }
			  }
		}
		
		try {
			FileOutputStream out = new FileOutputStream(new File("D:\\Employee_data_sheet.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Data write in File.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
