package helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DebugElementInIsolation {

    public static final String FORENAME = "Tim";

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgooldtt\\OneDrive - Ageas UK\\Documents\\SQC_Automation_Framework\\" +
                "bstof-selenium-example01\\sqc-bstof-starters-main\\emptyproject\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.get("C:\\Users\\rgooldtt\\OneDrive - Ageas UK\\Documents\\SQC_Automation_Framework\\elementDebug.html");

        boolean exists;
        driver.manage().window().maximize();

       // #### DO NOT DELETE - Need to create Helper / Base files for this section of files
        // DashboardLocatorLibrary dash = new DashboardLocatorLibrary(driver);

        try{
           // #### DO NOT DELETE - Need to create Helper / Base files for this section of files
            // exists = dash.getWelcomeHeader(FORENAME).isDisplayed();
        }catch (NoSuchElementException e){
            exists = false;
        }
        driver.quit();
    }


}
