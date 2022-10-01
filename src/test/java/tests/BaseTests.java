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

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTests {

    @BeforeAll
    public static void setUp(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        System.getProperty("host", "local");

        WebConfiguration config = ConfigFactory.create(WebConfiguration.class, System.getProperties());

        String login = config.login();
        String password = config.password();
        String baseUrl = System.getProperty("url");

        Configuration.baseUrl = baseUrl;
        Configuration.browser = System.getProperty("browser", "CHROME");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserPosition = "0x0";

        RestAssured.baseURI = baseUrl;

        if(Objects.equals("host", "remote")) {
        Configuration.remote = "https://" + login + ":" + password + "@" + config.remoteUrl() + "/wd/hub";}

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments(){

        if(Objects.equals("host", "remote")) {
        Attachments.screenshotAs("Screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();}

        closeWebDriver();
    }
}
