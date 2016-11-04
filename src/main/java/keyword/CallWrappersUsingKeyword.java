package keyword;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;
import wrappers.OpentapsWrappers;

public class CallWrappersUsingKeyword extends OpentapsWrappers{


	public CallWrappersUsingKeyword(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void getAndCallKeyword(String fileName) throws Exception{
		FileInputStream file = new FileInputStream(new File(fileName));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		Class<GenericWrappers> wrapper = GenericWrappers.class;
		Constructor<?> cons = wrapper.getConstructor(RemoteWebDriver.class,ExtentTest.class);

	    Object wM = cons.newInstance(driver,test);
	    
		// Get first/desired sheet from the workbook
		XSSFSheet sh = workbook.getSheetAt(0);
		for (int i = 1; i <= sh.getLastRowNum(); i++) {

			String keyword = "" ;
			String locator = "" ;
			String data = "" ;
			try {
				keyword = sh.getRow(i).getCell(0).getStringCellValue();
				locator = sh.getRow(i).getCell(1).getStringCellValue();
				data = sh.getRow(i).getCell(2).getStringCellValue();
			} catch (NullPointerException e) {
				// ignore
			}
			
			
			Method[] methodName = wrapper.getDeclaredMethods();
			
			for (Method method : methodName) {
				
				if(method.getName().toLowerCase().equals(keyword.toLowerCase())){
					System.out.println(driver);
					if(locator.equals("") && data.equals(""))
							method.invoke(wM);
					else if(locator.equals(""))
							method.invoke(wM,data);
					else if(data.equals(""))
						method.invoke(wM,locator);
					else
						method.invoke(wM,locator,data);
					
					// go out of for Loop
					break;

				}				
			}		
			
			workbook.close();
		}
		
	}
}
