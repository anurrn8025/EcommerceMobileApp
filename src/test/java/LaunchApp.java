
import java.io.File;
	import java.net.MalformedURLException;
	import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

	
public class LaunchApp {


	//static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
	
		//device
		dc.setCapability("deviceName","R5CT50AVJZH");
		dc.setCapability("platformName","Android");
		dc.setCapability("platformVersion","14");
		dc.setCapability("unlockType", "pattern");
		dc.setCapability("unlockKey", "456789"); // the nmbers in ur pattern
		//dc.setCapability("unlockType", "pin");
		//dc.setCapability("unlockKey", "123456"); // the pin passwd
		
		//app
				dc.setCapability("appPackage","com.solodroid.solomerce");
				dc.setCapability("appActivity","com.solodroid.solomerce.activities.MainActivity");
				dc.setCapability("noReset", true);
			
				Thread.sleep(3000);
				AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
				System.out.println("Operation begins"+"\n"); 
				Thread.sleep(3000);
				
				//MULTI TOUCH - use 2 touch Actions and move towards  each other . Perform both operations together
				
				/*
				 * MultiTouchAction action = new MultiTouchAction(driver);
				 * 
				 * TouchAction touch1 = new TouchAction(driver); TouchAction touch2 = new
				 * TouchAction(driver);
				 * 
				 * touch1.press(PointOption.point(293, 792)).moveTo(PointOption.point(293,
				 * 400)).release().wait(500); touch2.press(PointOption.point(293, 800
				 * )).waitAction().moveTo(PointOption.point(293, 1200)).release().wait(500);
				 * 
				 * action.add(touch1).add(touch1).perform().wait(500);
				 */
				
				
				//SCROLL OPERATION - use AndroidUIAutomator and UiScrollable & UiSelector classes (first scroll to the item and then click on it)
				
				
				  driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.solodroid.solomerce:id/viewpager\")).scrollForward().scrollIntoView(new "
				  + "UiSelector().textContains(\"GEA Baby\"))"); 
				  WebElement babyitem = driver.
				  findElementByAndroidUIAutomator("UiSelector().textContains(\"GEA Baby RayQueen Plus JHS-400 UV Sterilizer - Metal White\")"
				  );
				  
				  Thread.sleep(3000); babyitem.click(); Thread.sleep(3000);
				  System.out.println("Scroll completed");
				  
				  WebElement image = driver.
						  findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.solodroid.solomerce:id/product_image\")"
						  );
				  image.click();
				  System.out.println("Image clicked");
				  
				  Thread.sleep(3000);
				  WebElement image2 = driver.
						  findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.solodroid.solomerce:id/image\")"
						  );
				 
				  int leftX = image2.getLocation().getX();
			        int rightX = image2.getSize().getWidth() + leftX;
			        int midX = (leftX + rightX) / 2;
			        
			        int upperY = image2.getLocation().getY();
			        int lowerY = image2.getSize().getHeight() + upperY;
			        int midY = (upperY + lowerY) / 2;
			        
			        int aX = (int) (midX * 0.3);
			        int aY = (int) (midY * 1.7);
			        int bX = (int) (midX * 0.8);
			        int bY = (int) (midY * 1.2);

			        int cX = (int) (midX * 1.7);
			        int cY = (int) (midY * 0.3);
			        int dX = (int) (midX * 1.2);
			        int dY = (int) (midY * 0.8);
			        
				  MultiTouchAction action = new  MultiTouchAction(driver);
					
					TouchAction touch1 = new TouchAction(driver);
					TouchAction touch2 = new TouchAction(driver);
					
					//DPUBLE TAP
					TouchAction tap1 = new TouchAction(driver);
					tap1.tap(PointOption.point(405,2110)).perform().tap(PointOption.point(405,2110)).perform();
					System.out.println("Double tap completed");
					
					
					//tap1.tap(PointOption.point(405,2110)).perform();
					
					System.out.println("aX = " + aX);
					System.out.println("aY = " + aY);
					System.out.println("bX = " + bX);
					System.out.println("bY = " + bY);
					System.out.println("cX = " + cX);
					System.out.println("cY = " + cY);
					System.out.println("dX = " + dX);
					System.out.println("dY = " + dY);
					
					
					//touch1.press(image2,412, 1165).waitAction(2000).moveTo(image2,149, 1165).release();
					//touch1.press(PointOption.point(400, 1215)).waitAction(new WaitOptions().waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(100, 1215)).release();
					touch1.press(PointOption.point(432, 1314)).waitAction(new WaitOptions().waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(162, 1861)).release();
				
					
					
					//touch2.press(PointOption.point(500, 1215 )).waitAction(new WaitOptions().waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(800, 1215)).release();
					touch2.press(PointOption.point(648, 876)).waitAction(new WaitOptions().waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(918, 328)).release();
					
					
					
					action.add(touch1).add(touch2).perform();
				 
					System.out.println("finished");
				
				
				//MOVE FROM ONE APP TO ANOTHER APP-- here move from Ecommerce app to Calculator
				/*
				 * Thread.sleep(3000); Activity calc = new
				 * Activity("com.sec.android.app.popupcalculator",
				 * "com.sec.android.app.popupcalculator.Calculator");
				 * driver.startActivity(calc);
				 * 
				 * Thread.sleep(3000); driver.pressKey(new KeyEvent(AndroidKey.BACK));//--back button on the phone screen --try the other (Andriod keys) button as well
				 */
				
				
				//AppiumDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
				//driver.findElement(By.id("com.solodroid.solomerce:id/nav_profile")).click();
				//Thread.sleep(3000);
				
				//DEVICE LOCK AND UNLOCK ****give desired capabilities******
				
				/*
				 * driver.lockDevice(); 
				 * Thread.sleep(3000); 
				 * driver.unlockDevice();
				 */
				
				//SCREEN ROTATION
				/*
				 * System.out.println("Screen Orientation is : " + driver.getOrientation());
				 * 
				 * driver.rotate(ScreenOrientation.LANDSCAPE); Thread.sleep(3000);
				 * 
				 * System.out.println("Screen Orientation is : " + driver.getOrientation());
				 * 
				 * if(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)) {
				 * driver.rotate(ScreenOrientation.PORTRAIT);
				 * System.out.println("Screen rotated to : " + driver.getOrientation()); }
				 * driver.runAppInBackground(Duration.ofSeconds(10));
				 */
				
				//TAP OPERATION
				
				//hardcoding the coordinates
				
				/*TouchAction action = new TouchAction(driver);
				*action.tap(PointOption.point(405,2110)).release().perform();
				*/
				
				//to get cordinates dynamically
				
				/*
				 * WebElement category =
				 * driver.findElement(By.id("com.solodroid.solomerce:id/nav_category")); Point
				 * categorysize = category.getLocation(); System.out.println("element len is ="
				 * + categorysize.x); System.out.println("element width is =" + categorysize.y);
				 * 
				 * TouchAction action = new TouchAction(driver);
				 * action.tap(PointOption.point(categorysize.x,categorysize.y)).release().
				 * perform();
				 */
				
				//SWIPE
				
				/*
				 * TouchAction swipeAction = new TouchAction(driver); //left swipe
				 * swipeAction.press(PointOption.point(975,930)).moveTo(PointOption.point(150,
				 * 930)).release().perform(); System.out.println("Left swipe completed");
				 * 
				 * Thread.sleep(3000);
				 * 
				 * //right swipe
				 * swipeAction.press(PointOption.point(150,1134)).moveTo(PointOption.point(945,
				 * 1130)).release().perform(); System.out.println("Right swipe completed");
				 */
				
				//CALCULATOR
				//APP Package : com.sec.android.app.popupcalculator
				//App Activity : com.sec.android.app.popupcalculator/.Calculator
				
				//run the app in background
				/*driver.runAppInBackground(Duration.ofSeconds(10));*/
				
				
				
				
				

	}

}
