package co.com.jikkosoft.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Convertir {

	private static final Logger LOGGER =  Logger.getLogger(Convertir.class.getName());
	private static String pathColumn;
	private static List<WebElement> bodyTableColumns;
	private static List<WebElement> bodyTableRows;
	private static String modulo;


	public static List<List<String>> DataTable(WebDriver driver){
		List<List<String>> datos = new ArrayList<>();
		bodyTableRows = driver.findElements(By.xpath("//table/tbody/tr"));
		bodyTableColumns = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		for(int i=0 ; i<bodyTableRows.size() ; i++){
			List<String> dataToSave = new ArrayList<>();
			int numForPath = i+1;
			pathColumn = "//table/tbody/tr["+numForPath+"]/td[";
			for(int j=0 ; j<bodyTableColumns.size() ; j++){
				int numForPath2 = j+1;
				dataToSave.add(driver.findElement(By.xpath(pathColumn+numForPath2+"]")).getText().trim());
			}
			datos.add(dataToSave);
		}
		return datos;
	}
}
