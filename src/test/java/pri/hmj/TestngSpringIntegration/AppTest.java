package pri.hmj.TestngSpringIntegration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 * mvn test -DtestngxmlName=testng.xml
 * mvn命令执行一定要test结尾
 * clean 后要 project clean 
 * 测试
 */
public class AppTest  
    
{

	private Logger logger;
   
	@Test
	public void test() {
		//优先级从高到低分别是ERROR、WARN、INFO、DEBUG
		// 由于使用谷歌浏览器，需要下载谷歌驱动,并指定路径
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\log4j.properties");// 加载.properties文件
		logger = Logger.getLogger(AppTest.class);
		logger.info("開始2");
		Reporter.log("开始");
		Reporter.log("开始2");
		System.setProperty("webdriver.chrome.driver", "D:\\driver_exe\\chromedriver_win32(2.40)\\chromedriver.exe");
		System.out.println("驱动");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.baidu.com/");
		System.out.println("启动");
		driver.manage().window().maximize();

		WebElement wd = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
		wd.sendKeys("查询");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(true);
		driver.quit();
		// driver.close();//不会清除临时文件

	}

}
