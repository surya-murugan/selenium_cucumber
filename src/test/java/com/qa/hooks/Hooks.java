package com.qa.hooks;
import com.qa.utils.ScreenshotUtil;
import com.qa.base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.nio.file.Files;
import java.nio.file.Path;
public class Hooks {

    @Before
    public void setUp() {

        DriverFactory.initializeDriver();

    }

   /* @After
    public void tearDown() {

       DriverFactory.quitDriver();

    }*/

       @After
    public void tearDown(Scenario scenario) {

      /* ------This is enough for screenshot-----
       if (scenario.isFailed()) {

            String screenshotPath =
                    ScreenshotUtil.takeScreenshot(
                            DriverFactory.getDriver(),
                            scenario.getName()
                    );

            System.out.println(
                    "Screenshot saved: " + screenshotPath
            );
        }

        DriverFactory.quitDriver();
     ----------------------The below one is for cucumber reports main line is scenario.attach--------------*/


    if (scenario.isFailed()) {

            String screenshotPath =
                    ScreenshotUtil.takeScreenshot(
                            DriverFactory.getDriver(),
                            scenario.getName()
                    );

            try {

                byte[] screenshot =
                        Files.readAllBytes(
                                Path.of(screenshotPath)
                        );

                scenario.attach(
                        screenshot,
                        "image/png",
                        "Failure Screenshot"
                );

            } catch (Exception e) {

                System.out.println(
                        "Unable to attach screenshot"
                );
            }
        }

       // DriverFactory.quitDriver();
    }
}

