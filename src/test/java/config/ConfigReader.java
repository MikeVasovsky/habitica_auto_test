package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    public static final TestConfig testConfig = createTestConfig();

    private static TestConfig createTestConfig() {
        if (!System.getProperties().containsKey("env")) {
            System.setProperty("env", "LOCAL");
        }
        return ConfigFactory.create(TestConfig.class, System.getProperties());
    }

    public TestConfig read() {
        return testConfig;
    }
}
