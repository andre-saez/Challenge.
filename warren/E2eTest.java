package warren.warren;

import static org.junit.Assert.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;

public class E2eTest {

	public WebDriver driver;
	public String baseUrl;
	public String baseCadastro;
	public String ct;

	// Preparação para o teste - Navegação ao site e maximização da tela
	@Before
	public void beforeClassTest() throws Exception {
		// System.setProperty("webdriver.chrome.driver", "D:/Program Files(x86)/Libs/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseCadastro = "https://seubarriga.wcaquino.me/cadastro";
		baseUrl = "https://seubarriga.wcaquino.me/login";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	// Cadastro do cliente na página
	@Test
	public void cadastrarUsuarioTest() throws InterruptedException {
		driver.get(baseCadastro);
		WebElement cadastro = driver.findElement(By.xpath("//a[@href='/cadastro']"));
		cadastro.click();
		Thread.sleep(3000);

		WebElement nameField = driver.findElement(By.id("nome"));
		nameField.sendKeys("Andre");
		System.out.println("Nome informado com sucesso.");

		WebElement eMail = driver.findElement(By.id("email"));
		eMail.sendKeys("andre.saez@gmail.com");
		System.out.println("E-mail informado com sucesso.");

		WebElement passWord = driver.findElement(By.id("senha"));
		passWord.sendKeys("1234");
		System.out.println("Senha criada com sucesso.");

		WebElement teclaCadastrar = driver.findElement(By.xpath("//input[@safeclass~'\bbtn\b.*\bbtn-primary\b']"));
		teclaCadastrar.click();
	}

	// Login e acesso do cliente à página após o cadastro
	@Test
	public void efetuarLoginTest() throws Exception {
		driver.get(baseUrl);
		WebElement emailAdress = driver.findElement(By.id(("email")));
		emailAdress.sendKeys("andre.saez@gmail.com");

		WebElement passWord = driver.findElement(By.id("senha"));
		passWord.sendKeys("1234");

		WebElement teclaEntrar = driver.findElement(By.xpath("//button[@type='submit']"));
		teclaEntrar.click();
	}

	// Criação de nova conta 
	@Test
	public void criarContaTest() throws Exception {
		driver.get(baseUrl);
		WebElement contas = driver.findElement(By.xpath("//a[@role='button']"));
		contas.click();

		List<WebElement> adicionar = driver.findElements(By.xpath("//a[@href='/addConta']"));
		((WebElement) adicionar).click();

		WebElement nomeConta = driver.findElement(By.id("nome"));
		nomeConta.sendKeys("TesteConta");

		WebElement salvarConta = driver.findElement(By.className("btn btn-primary"));
		salvarConta.click();
	}

	// Encerramento da sessão e fechamento da página
	@Test
	public void encerrarSessao() throws Exception {
		driver.get(baseUrl);
		WebElement sairApp = driver.findElement(By.xpath("//a[@href='/logout']"));
		sairApp.click();
	}

	// 
	@After
	public void fecharBrowser() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}
}