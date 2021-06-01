
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBrokenLinksAndImages

{
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "C://Users/sanka/Documents/ChromeDriverEXE/new/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		// get list of all links and images with below tags
		List<WebElement> list = driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("img")));

		// get size of list
		System.out.println("All links are :" + list.size());

		List<WebElement> activelist = new ArrayList<WebElement>(); // to store only those links out of list where href
																	// has some value

		// iterate list : exclude all links and images that dont have href attribute
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAttribute("href") != null) {
				activelist.add(list.get(i));
			}
		}

		// get size of activelist
		System.out.println("Active links are :" + activelist.size());

		// check href with http connection api
		for (int j = 0; j < activelist.size(); j++) {
			// created URL class object and for the string url i'm casting it into httpurlconnection
			URL url = new URL(activelist.get(j).getAttribute("href"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			String response = conn.getResponseMessage();
			int responseCode=conn.getResponseCode();
			conn.disconnect();
			System.out.println(activelist.get(j).getAttribute("href") + "-->" + response +"and" + responseCode);

		}
	}
}
