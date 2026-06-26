package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties",
        "system:properties"})

public interface TestConfig extends Config {

    @Key("url.baseUrl")
    @DefaultValue("")
    String gerUrl();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browser.name")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browser.version")
    @DefaultValue("130")
    String getBrowserVersion();

    @Key("browser.size")
    @DefaultValue("1980x1080")
    String getBrowserSize();

    @Key("pageLoadStrategy")
    @DefaultValue("eager")
    String getLoadStrategy();

    @Key("env")
    @DefaultValue("LOCAL")
    Remote getEnv();

}
