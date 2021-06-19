package test.java;

import java.awt.TextComponent;
import java.awt.TextField;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Souq_comtest {
	private static FileWriter file;

	public static void main(String[] args) {

		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohamed\\new eclipse\\selenium\\chromedriver\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();

		// Launch Website
		driver.navigate().to("https://egypt.souq.com/eg-en/");
		WebElement searchValue = driver.findElement(By.xpath("//*[@id=\"search_value\"]"));

		searchValue.sendKeys("Iphone");
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchButton\"]"));
		searchButton.click();
		List<WebElement> IphoneList = driver.findElements(By.xpath("//*[@id=\"content-body\"]/div[7]/div/div/div"));
		// *[@id="content-body"]/div[7]/div/div
		// *[@id="content-body"]/div[7]/div/div/div[2]
		String divsXpath = "//*[@id=\\\"content-body\\\"]/div[7]/div/div/div";
		JSONArray iphoneListJSON = new JSONArray();
		for (int i = 1; i < IphoneList.size() && i <= 20; i++) {
			JSONObject obj = new JSONObject();
			obj.put("Title",
					((WebElement) driver
							.findElement(By.xpath("//*[@id=\"content-body\"]/div[7]/div/div/div[" + i + "]/div[2]/a")))
									.getText());
			obj.put("Price", ((WebElement) driver.findElement(By
					.xpath("//*[@id=\"content-body\"]/div[7]/div/div/div[" + i + "]/div[3]/ul/li[1]/div[1]/div[1]/h3")))
							.getText());
			iphoneListJSON.add(obj);
//			String tata = ((WebElement) driver.findElement(By.xpath("//*[@id=\"content-body\"]/div[7]/div/div/div[" + i + "]/div[2]/a")))
//					.getText();
		}
		JSONObject output = new JSONObject();

		output.put("Results", iphoneListJSON);
		try {

			// Constructs a FileWriter given a file name, using the platform's default
			// charset
			file = new FileWriter("C:\\Users\\mohamed\\new eclipse\\selenium\\chromedriver\\iPhoneList.txt");
			file.write(output.toJSONString());
//            CrunchifyLog("Successfully Copied JSON Object to File...");
//            CrunchifyLog("\nJSON Object: " + obj);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				file.flush();
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
