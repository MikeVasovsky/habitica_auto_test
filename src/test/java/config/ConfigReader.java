package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    public static final TestConfig testConfig = createTestConfig();

    private static TestConfig createTestConfig() {
        System.setProperty("env", System.getProperty("env", "local").toLowerCase());
        return ConfigFactory.create(TestConfig.class, System.getProperties());
    }

    public TestConfig read() {
        return testConfig;
    }
}
