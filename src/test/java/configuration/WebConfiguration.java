package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${host}.properties"})
public interface WebConfiguration extends org.aeonbits.owner.Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browser.version")
    @DefaultValue("103.0")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("base.url")
    @DefaultValue("https://4fresh.ru")
    String baseUrl();

    @Key("remote.url")
    String remoteUrl();
}