package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.Configuration;
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

        host = System.getProperty("host", "local");
        String baseUrl = System.getProperty("url", "https://4fresh.ru");

        com.codeborne.selenide.Configuration.baseUrl = baseUrl;
        RestAssured.baseURI = baseUrl;
        com.codeborne.selenide.Configuration.browser = System.getProperty("browser", "CHROME");
        com.codeborne.selenide.Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        com.codeborne.selenide.Configuration.browserPosition = "0x0";

        Configuration config = ConfigFactory.create(Configuration.class);
        String login = config.login();
        String password = config.password();
        String remote = config.remoteUrl();

        if(host.equals("remote")) {
            com.codeborne.selenide.Configuration.remote = "https://" + login + ":" + password + "@" + remote + "/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            com.codeborne.selenide.Configuration.browserCapabilities = capabilities;
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
