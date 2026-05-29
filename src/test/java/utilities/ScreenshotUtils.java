package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver,
                                         String testName) {

        try {

            // Take Screenshot
            TakesScreenshot ts =
            (TakesScreenshot) driver;

            File source =
            ts.getScreenshotAs(OutputType.FILE);

            // Create Folder Automatically
            File folder =
            new File("./Screenshots");

            if (!folder.exists()) {

                folder.mkdir();
            }

            // Destination File
            File destination =
            new File("./Screenshots/"
                     + testName + ".png");

            // Copy File
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot Saved");

            System.out.println(destination.getAbsolutePath());

        } catch (IOException e) {

            System.out.println("Screenshot Failed");

            e.printStackTrace();
        }
    }
}