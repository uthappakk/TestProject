package boot;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadExcelFile {
	@Before
	public void setup() throws Exception{
		System.out.println("***Reading Excel File***");
		System.out.println();
	}
	
	@Test
	public void ReadFile() throws Exception{
		FileInputStream fs = new FileInputStream("excel/excel.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getRow(0).getCell(0)+"     "+sh.getRow(0).getCell(1));
		System.out.println("--------------------------");
		int noofrows=sh.getLastRowNum();
		for(int i=1;i<=noofrows;i++) {
			System.out.println(sh.getRow(i).getCell(0)+"     "+sh.getRow(i).getCell(1));
		}
	}
	
	@After
	public void tearDown() {
		
		System.out.println();
		System.out.println("***Excel File Read***");
	}
}

