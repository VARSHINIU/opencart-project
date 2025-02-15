package testbase;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

import javax.annotation.ParametersAreNonnullByDefault;

public class baseclass {

    public static WebDriver driver;
    public Logger logger;//log4j2
    public Properties p;
   public  WebDriverWait wait;


    @BeforeClass
   // @Parameters({"browser"})
   public  void setup()  {
//        if(browsername.equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver","C:\\Users\\SARAN\\IdeaProjects\\myproject\\browser drivers\\chromedriver.exe");
//            driver=new ChromeDriver();
//        }else if(browsername.equalsIgnoreCase("edge")){
//            System.setProperty("webdriver.edge.driver","C:\\Users\\SARAN\\IdeaProjects\\myproject\\browser drivers\\msedgedriver.exe");
//            driver =new EdgeDriver();
//        }else{
//            System.out.println("no browser instaal in my ysytem  -executing default browser");
//            System.setProperty("webdriver.chrome.driver","C:\\Users\\SARAN\\IdeaProjects\\myproject\\browser drivers\\chromedriver.exe");
//            driver=new ChromeDriver();
//        }
//
   try {
       FileReader file = new FileReader("C:\\Users\\SARAN\\IdeaProjects\\Opencart\\src\\test\\resources\\config.properties");
       p = new Properties();
       p.load(file);
   } catch (IOException e) {
       throw new RuntimeException(e);
   }

        logger= LogManager.getLogger(this.getClass());

        System.setProperty("webdriver.chrome.driver","C:\\Users\\SARAN\\IdeaProjects\\Opencart\\browser drivers\\chromedriver.exe");
        if (driver == null) {  // Check if driver is already initialized
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://demo.opencart.com.gr/");
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @AfterSuite
    public void teardown(){
        driver.quit();
    }

    public String randomString()
    {
        String generatedmail= RandomStringUtils.randomAlphabetic(5);
        return generatedmail;
    }

    public String randomnum()
    {
        String generatednum= RandomStringUtils.randomNumeric(10);
        return generatednum;
    }

    public String randompass()
    {
        String generatedpass= RandomStringUtils.randomNumeric(3);
        return generatedpass;
    }
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

}
