package warren.warren;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Api {

	public WebDriver driver;
	public String baseUrl;

	//Preparação para o teste - Navegação ao site e maximização da tela
	@BeforeTest
	public void beforeTest() {
		// System.setProperty("webdriver.chrome.driver", "D:/Program Files// (x86)/Libs/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://barrigareact.wcaquino.me/login";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	//Login e acesso do cliente à página
	@Test
	public void f() throws InterruptedException {
		driver.get(baseUrl);
		WebElement eMail = driver.findElement(By.xpath("//input[@placeholder='seu@email.com']"));
		eMail.sendKeys("andre.saez@gmail.com");

		WebElement passWord = driver.findElement(By.xpath("//input[@placeholder='Senha']"));
		passWord.sendKeys("1234");

		WebElement clicar = driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary']"));
		clicar.click();
		Thread.sleep(5000);
	}

	//Fechamento do browser
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}