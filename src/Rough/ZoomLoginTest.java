package Rough;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class ZoomLoginTest {

    public static void main(String[] args) throws Exception {

        // Set up desired capabilities for the WinAppDriver server and the Zoom desktop app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("app", "C:\\Users\\Dell\\AppData\\Roaming\\Zoom\\bin\\Zoom.exe");

        // Start a new session with the WinAppDriver server and the Zoom app
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723"), capabilities);

        // Locate the login fields in the Zoom app and enter your login credentials
        driver.findElementByName("username").sendKeys("ishan@sen-sei.in");
        driver.findElementByName("password").sendKeys("Zoom_123");
        driver.findElementByName("login").click();

        // Close the session when you're done
        driver.quit();
    }
}
