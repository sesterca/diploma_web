package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.WebConfiguration;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTests {

    static String host;

    @BeforeAll
    public static void setUp(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        host = System.setProperty("host", "local");
        String baseUrl = System.getProperty("url", "https://4fresh.ru");

        Configuration.baseUrl = baseUrl;
        RestAssured.baseURI = baseUrl;
        Configuration.browser = System.getProperty("browser", "CHROME");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserPosition = "0x0";

        WebConfiguration config = ConfigFactory.create(WebConfiguration.class);
        String login = config.login();
        String password = config.password();
        String remote = config.remoteUrl();

        if(host.equals("remote")) {
            Configuration.remote = "https://" + login + ":" + password + "@" + remote + "/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @AfterEach
    void addAttachments(){

        if(host.equals("remote")) {
            Attachments.screenshotAs("Screenshot");
            Attachments.pageSource();
            Attachments.browserConsoleLogs();
            Attachments.addVideo();
        }
            closeWebDriver();
    }
}
