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

        System.setProperty("host", "local");

        WebConfiguration config = ConfigFactory.create(WebConfiguration.class);

        String login = config.login();
        String password = config.password();

        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        Configuration.browserPosition = "0x0";

        RestAssured.baseURI = config.baseUrl();

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
