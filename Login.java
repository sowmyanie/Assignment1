import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Login {
        WebDriver driver;

        @Before
        public void setupBrowser() throws InterruptedException {
            System.setProperty("web-driver.chrome.driver", "C:\\Users\\CG291PC\\OneDrive - EY\\Desktop\\Java_Selenium training\\Assignment1\\src\\main\\resources\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(500);
        }

        @After
        public void closeBrowser()
        {
            // driver.close();
            driver.quit();
        }

    //Register user
    @Given("User launches the url or application")
    public void user_launches_the_url_or_application() throws InterruptedException, IOException {
        //driver.get("https://demo.guru99.com/test/newtours/register.php");
        File file = new File("./TestData/TestData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(fis);  //.xlsx format
        Sheet sh = wb.getSheet("TestDataSheet");
        System.out.println("before");
        String url = sh.getRow(1).getCell(0).getStringCellValue();
        System.out.println("after");
        driver.navigate().to(url);
        Thread.sleep(500);
        //write to excel
//        Sheet sheet1 = wb.getSheetAt(3);
//       int lastRow = sh.getLastRowNum();
//        Cell cell = null;
//       for (int i = 3; i <= lastRow; i++) {
//            Row row = sh.getRow(i);
//            cell = row.createCell(4);
//        }
//        cell.setCellValue("Write into Excel");
//        System.out.println(("Written to excel"));

    }

    @Given("user enters all details")
    public void userEntersAllDetails() {
        driver.findElement(By.xpath("//input[1][@name='firstName']")).sendKeys("Chinnu");
        driver.findElement(By.xpath("//input[1][@name='lastName']")).sendKeys("S");
        driver.findElement(By.id("userName")).sendKeys("chinnu123@gmail.com");
        driver.findElement(By.id("email")).sendKeys("chinnu123@gmail.com");
        driver.findElement(By.xpath("//input[1][@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[1][@name='confirmPassword']")).sendKeys("password");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @When("user clicks on Submit button of reg")
    public void userClicksOnSubmitButtonOfReg() throws IOException {
        driver.findElement(By.xpath("//input[1][@name='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakesScreenshot ts =(TakesScreenshot) driver; //Convert web driver object to TakeScreenshot
        File srcFile = ts.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
        //Copy file to Desired Location
        File tarFile = new File("C:\\Users\\CG291PC\\OneDrive - EY\\Desktop\\Java_Selenium training\\Assignment1\\src\\test\\Screen shots\\Registered.png");
        FileUtils.copyFile(srcFile,tarFile);
        System.out.println("ss taken");
    }

    @Then("USer logged into the application")
    public void u_ser_logged_into_the_application() {
        System.out.println("registered");
    }



    //valid scenario for login
    @Given("launch application")
    public void launchApplication() {
        driver.get("https://demo.guru99.com/test/newtours/");
    }


    @And("user enters <username> and <password>")
    public void userEntersUsernameAndPassword() throws IOException {
        driver.findElement(By.xpath("//input[1][@name='userName']")).sendKeys("chinnu123@gmail.com");
        driver.findElement(By.xpath("//input[1][@name='password']")).sendKeys("password");
        TakesScreenshot ts =(TakesScreenshot) driver; //Convert web driver object to TakeScreenshot
        File srcFile = ts.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
        //Copy file to Desired Location
        File tarFile = new File("C:\\Users\\CG291PC\\OneDrive - EY\\Desktop\\Java_Selenium training\\Assignment1\\src\\test\\Screen shots\\Loggedin.png");
        FileUtils.copyFile(srcFile,tarFile);
        System.out.println("UN and Pwd");
    }

    @When("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
        driver.findElement(By.xpath("//input[1][@name='submit']")).click();
    }

    @Then("User logged in")
    public void userLoggedIn() {
        System.out.println("Welcome to demo guru!!logged in");
    }

     @Given("launch the application")
    public void launchTheApplication() {
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    @And("user enters <inusername> and <inpassword>")
    public void userEntersInusernameAndInpassword() {
        driver.findElement(By.xpath("//input[1][@name='userName']")).sendKeys("chinnu1@gmail.com");
        driver.findElement(By.xpath("//input[1][@name='password']")).sendKeys("passwod");
    }



    @When("User clicks on Submit button for invalid scenario")
    public void userClicksOnSubmitButtonForInvalidScenario() {
        driver.findElement(By.xpath("//input[1][@name='submit']")).click();
    }

    @Then("User must not be able to login")
    public void userMustNotBeAbleToLogin() {
        System.out.println("Unable to login with Invalid creds");
    }


        //booking flight ticket
        @Given("launch application for booking flight")
        public void launch_application_for_booking_flight() {
            // Write code here that turns the phrase above into concrete actions
            driver.get("https://demo.guru99.com/test/newtours/");
        }


    @Given("user enters her <username> and <password>")
    public void user_enters_her_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[1][@name='userName']")).sendKeys("chinnu123@gmail.com");
        driver.findElement(By.xpath("//input[1][@name='password']")).sendKeys("password");
    }

    @When("user clicks on flight book")
    public void user_clicks_on_flight_book() throws InterruptedException {
       //driver.findElement(By.xpath("https://demo.guru99.com/test/newtours/reservation.php")).click();
        driver.findElement(By.xpath("//a[@href=\"reservation.php\"][1]")).click();
              Thread.sleep(200);
//
//        driver.findElement(By.xpath("//input[@name='tripType' and @value='roundtrip']")).click();
//        Select Dropdown= new Select(driver.findElement(By.name("passCount")));
//        Dropdown.selectByValue("2");
//        Select departfrom= new Select(driver.findElement(By.name("fromPort")));
//        departfrom.selectByValue("London");
//        Select frommonth= new Select(driver.findElement(By.name("fromMonth")));
//        frommonth.selectByValue("December");
//        Select fromday= new Select(driver.findElement(By.name("fromDay")));
//        fromday.selectByValue("29");
//        Select destination= new Select(driver.findElement(By.name("toPort")));
//        destination.selectByValue("Sydney");
//        Select tomonth= new Select(driver.findElement(By.name("fromMonth")));
//        tomonth.selectByValue("December");
//        Select to_day= new Select(driver.findElement(By.name("fromDay")));
//        to_day.selectByValue("31");
//        driver.findElement(By.xpath("//input[@name='servClass' and @value='Business']")).click();
//        Select airline= new Select(driver.findElement(By.name("airline")));
//        airline.selectByIndex(1);
    }


    @Then("book flight last")
    public void book_flight_last() {
            System.out.println("Continue button");
    }
}
