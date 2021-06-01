import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoIbiboExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users/sanka/Documents/ChromeDriverEXE/new/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!ETA!108599293!6504095653!491718594877!e!goibibo!c!&ef_id=Cj0KCQjw78yFBhCZARIsAOxgSx0xr52xpHMw-HSMkCLF4TVzH3soWPg2PivpxC090BHpxrDjmeoAGVcaAjmKEALw_wcB:G:s&gclid=Cj0KCQjw78yFBhCZARIsAOxgSx0xr52xpHMw-HSMkCLF4TVzH3soWPg2PivpxC090BHpxrDjmeoAGVcaAjmKEALw_wcB");
		driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='DayPicker-Body']")));

		String monthYearValue = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		System.out.println(monthYearValue);

		String arr[] = monthYearValue.split(" ", 2);
		String month = arr[0];
		String year = arr[1];
		System.out.println(month);
		System.out.println(year);

		while (!(month.equals("August") && year.equals("2021"))) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			monthYearValue = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			System.out.println(monthYearValue);
			String arr1[] = monthYearValue.split(" ", 2);
			month = arr1[0];
			year = arr1[1];
			System.out.println(month);
			System.out.println(year);
		}

		driver.findElement(By.xpath("//div[text()='31']")).click();
		driver.quit();

	}

}
