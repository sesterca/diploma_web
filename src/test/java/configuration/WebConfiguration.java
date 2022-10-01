package configuration;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:remote.properties"})
public interface WebConfiguration extends org.aeonbits.owner.Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("remote.url")
    String remoteUrl();
}