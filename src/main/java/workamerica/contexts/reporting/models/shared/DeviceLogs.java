package workamerica.contexts.reporting.models.shared;

/**
 * Created by Faizan on 8/9/2016.
 */
public class DeviceLogs {

    private String deviceType;
    private String vendor;
    private String operatingSystem;
    private String browser;
    private String browserVersion;

    public DeviceLogs(String deviceType, String vendor, String operatingSystem, String browser, String browserVersion) {
        this.deviceType = deviceType;
        this.vendor = vendor;
        this.operatingSystem = operatingSystem;
        this.browser = browser;
        this.browserVersion = browserVersion;
    }

    public DeviceLogs () {}

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
