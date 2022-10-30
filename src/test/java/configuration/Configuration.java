package configuration;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:remote.properties"})
public interface Configuration extends org.aeonbits.owner.Config {

    String login();

    String password();

    @Key("remote")
    String remoteUrl();

    @Key("video")
    String videoUrl();
}