import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateHandlingFromCalendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users/sanka/Documents/ChromeDriverEXE/new/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));

		String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearValue);

		String arr[] = monthYearValue.split(" ", 2);

		String month = arr[0];
		String year = arr[1];
		System.out.println(month);
		System.out.println(year);

		while (!(month.equals("July") && year.equals("2022"))) {

			driver.findElement(By.xpath("//a[@title='Next']")).click();
			
			monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
			String arr1[] = monthYearValue.split(" ", 2);
			month = arr1[0];
			year = arr1[1];
			System.out.println(monthYearValue);
			System.out.println(month);
			System.out.println(year);

		}
		driver.findElement(By.xpath("//a[text()='23']")).click(); 
		driver.quit();
	}
}
