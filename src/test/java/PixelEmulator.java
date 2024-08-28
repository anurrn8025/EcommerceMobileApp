import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class PixelEmulator {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		//device
		dc.setCapability("deviceName","sdk_gphone64_x86_64");
		dc.setCapability("platformName","Android");
		dc.setCapability("platformVersion","13");
		
		dc.setCapability("appPackage","com.solodroid.solomerce");
		dc.setCapability("appActivity","com.solodroid.solomerce.activities.MainActivity");
		dc.setCapability("noReset", true);
		
		//camera app
				//dc.setCapability("appPackage","com.android.camera2");
				//dc.setCapability("appActivity","com.android.camera.CameraLauncher");
				//dc.setCapability("noReset", true);
				
		//General Store App
				//dc.setCapability("appPackage","com.androidsample.generalstore");
				//dc.setCapability("appActivity","com.androidsample.generalstore/.MainActivity");
				//dc.setCapability("noReset", true);
			
				Thread.sleep(3000);
				AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
				System.out.println("Operation begins"+"\n"); 
				Thread.sleep(3000);
				
				System.out.println("App opened");
				 WebElement arrowEle = driver.
						  findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.androidsample.generalstore:id/spinnerCountry\")"
						  );
				 arrowEle.click();
				  System.out.println("Arrow clicked");

	}

}
