package week1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(" https://demo.dealsdray.com/");

		Thread.sleep(2000);
		WebElement element = driver
				.findElement(By.xpath("//div[contains(@class,'MuiOutlinedInput-root MuiInputBase-root')]//input"));
		element.sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(2000);
		WebElement element2 = driver
				.findElement(By.xpath("(//div[contains(@class,'MuiOutlinedInput-root MuiInputBase-root')]//input)[2]"));
		element2.sendKeys("prexo.mis@dealsdray.com");

		driver.findElement(By.xpath("//div[@class='MuiBox-root css-79elbk']//button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='sidenavHoverShow collapseIcon']//span[1]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Orders']")).click();

		driver.findElement(By.xpath("//div[@class='MuiBox-root css-0']//button[1]")).click();

		Thread.sleep(2000);
		WebElement upload_file = driver
				.findElement(By.xpath("//div[contains(@class,'MuiOutlinedInput-root MuiInputBase-root')]//input[1]"));
		upload_file.sendKeys("C:\\Users\\Administrator\\Downloads\\demo-data.xlsx");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-1xi4464']//button[1]")).click();

		driver.findElement(By.xpath("//div[@class='MuiBox-root css-1xi4464']//button[1]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Shutterbug.shootPage(driver, Capture.FULL_SCROLL,
		// true).save("C:\\Users\\Administrator\\Pictures\\runtimeScreenshots");

		Shutterbug.shootPage(driver, Capture.FULL, true).save("./images/firstPage.png");

		Actions actions = new Actions(driver);
		Actions builder = actions.keyDown(Keys.PAGE_DOWN);
		builder.perform();

		Shutterbug.shootPage(driver, Capture.FULL, true).save("./images/middlePage.png");

		Actions keys = actions.keyDown(Keys.PAGE_DOWN);
		keys.perform();
		Shutterbug.shootPage(driver, Capture.FULL, true).save("./images/lastPage.png");

		Actions key = actions.keyDown(Keys.PAGE_DOWN);
		key.perform();
		Shutterbug.shootPage(driver, Capture.FULL, true).save("./images/lastPage1.png");

		Actions ke = actions.keyDown(Keys.PAGE_DOWN);
		ke.perform();
		Shutterbug.shootPage(driver, Capture.FULL, true).save("./images/lastPage2.png");

	}

}
