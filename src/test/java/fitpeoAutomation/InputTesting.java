package fitpeoAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InputTesting {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[text()='Revenue Calculator']")).click();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement slider=driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']/span[3]"));
		
		Actions act= new Actions(driver);
		
		js.executeScript("window.scrollBy(0,500)","");
		//input box
		WebElement input=driver.findElement(By.xpath("//div[@class='MuiFormControl-root MuiTextField-root css-1s5tg4z']//input"));
		
		//Getting Slider location(x,y) for multiple input values
		for(int i=550;i<=600;i+=2)
		{	
		input.click();
		act.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(4000);
		input.sendKeys(String.valueOf(i));
		Thread.sleep(3000);
		System.out.println("slider Location for " +i +"  " +slider.getLocation()); 
		
		// here for all the inputs, sliders are not moving according to number provided in input
		/*slider Location for 550  (856, 654)
		slider Location for 552  (856, 654)
		slider Location for 554  (856, 654)
		slider Location for 556  (857, 654)
		slider Location for 558  (857, 654)
		slider Location for 560  (857, 654)
		slider Location for 562  (857, 654)
		slider Location for 564  (858, 654)
		slider Location for 566  (858, 654)
		slider Location for 568  (858, 654)
		slider Location for 570  (859, 654)
		slider Location for 572  (859, 654)
		slider Location for 574  (859, 654)
		slider Location for 576  (860, 654)
		slider Location for 578  (860, 654)
		slider Location for 580  (860, 654)
		slider Location for 582  (860, 654)
		slider Location for 584  (861, 654)
		slider Location for 586  (861, 654)
		slider Location for 588  (861, 654)
		slider Location for 590  (862, 654)
		slider Location for 592  (862, 654)
		slider Location for 594  (862, 654)
		slider Location for 596  (863, 654)
		slider Location for 598  (863, 654)
		slider Location for 600  (863, 654)*/

		}

	}

}
