package AppHooks;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty()
    {
        configReader=new ConfigReader();
        prop=configReader.init_prop();
    }
    @Before(order = 1)
    public void launchbrowser(){
        String browsername=prop.getProperty("browser");
        driverFactory=new DriverFactory();
        driver=driverFactory.init_driver(browsername);
    }
    @After(order = 0)
    public void quitbrowser(){
        driver.quit();
    }
    @After(order = 1)
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            //take screenshot
            String screenshotname=scenario.getName().replaceAll(" ","_");
            byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcepath,"image/png",screenshotname);

        }
    }
}
