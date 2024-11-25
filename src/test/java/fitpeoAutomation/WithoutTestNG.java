package fitpeoAutomation;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WithoutTestNG {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver= new ChromeDriver();
		driver.get("https://fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[text()='Revenue Calculator']")).click();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//WebElement slider=driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']/span[3]"));
		
		Actions act= new Actions(driver);
		//input box
		WebElement input=driver.findElement(By.xpath("//div[@class='MuiFormControl-root MuiTextField-root css-1s5tg4z']//input"));
		
		input.click();
		act.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		
		input.sendKeys("560"); 
		Thread.sleep(2000);
		
		
		input.click();
		act.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		input.sendKeys("820");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,200)","");
		
		//selecting check boxes
		List<WebElement> Chkbox=driver.findElements(By.xpath("//div[@class=\"MuiBox-root css-1p19z09\"]/div//input"));
		List<WebElement> CName=driver.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt']"));
		
		for(int i=0;i<CName.size();i++)
		{
			String CPT=CName.get(i).getText();
			if(CPT.equals("CPT-99091")||CPT.equals("CPT-99453")||CPT.equals("CPT-99454")||CPT.equals("CPT-99474"))
			{
				Chkbox.get(i).click();
				Thread.sleep(2000);
				
			}	
		}
				
		String amt=driver.findElement(By.xpath("//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-1lnu3ao']/p[4]/p")).getText();
		System.out.println(amt);
		
		if (amt.equals("$110700"))
			System.out.println("Total Recurring Reimbursement for all Patients Per Month: "+amt);
			
		
		driver.quit();
	}
	 
}	
		
	


