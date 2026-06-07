package config;

import org.aeonbits.owner.Config;
@Config.Sources({"classpath:local.properties"})

public interface TestConfig extends Config {

    @Key("url.baseUrl")
    @DefaultValue("")
    String gerUrl();

    @Key("browser.name")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browser.version")
    @DefaultValue("")
    String getBrowserVersion();

    @Key("browser.size")
    @DefaultValue("1980x1080")
    String getBrowserSize();

    @Key("pageLoadStrategy")
    @DefaultValue("eager")
    String getLoadStrategy();

}
