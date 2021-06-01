import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethodForDateHandlingFromCalendar {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users/sanka/Documents/ChromeDriverEXE/new/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));

		selectDate("1", "June", "2021");
	}

	public static String[] getMonthYear(String monthYearValue) {
		return monthYearValue.split("");

	}

	public static void selectDate(String Day, String Month, String Year) {
		String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
		while (!(getMonthYear(monthYearValue)[0].equals(Month) && getMonthYear(monthYearValue)[1].equals(Year))) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
		}

		driver.findElement(By.xpath("//a[text()='" + Day + "']")).click();

	}
}
