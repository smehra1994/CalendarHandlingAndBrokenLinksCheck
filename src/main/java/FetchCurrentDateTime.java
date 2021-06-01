
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FetchCurrentDateTime {

	WebDriver driver;
	
	@Test
	public void getDateTime()
	{
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date d=new Date();
		String dateOfSystem=df.format(d);
		System.out.println(dateOfSystem);
	}
}
