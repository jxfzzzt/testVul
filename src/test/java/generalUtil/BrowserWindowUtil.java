package generalUtil;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class BrowserWindowUtil {

	WebDriver driver = null;

	public BrowserWindowUtil(WebDriver driver) {
		this.driver = driver;

	}
	
	public void MaximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public void MinimizeBrowserWindow() {
		driver.manage().window().minimize();
	}
	
	public void SetBrowserWindow(String size) {
		Dimension customSize = new Dimension(Integer.parseInt(size.split("x")[0]), Integer.parseInt(size.split("x")[1]));
		driver.manage().window().setSize(customSize);;
	}
	
	
	

}
