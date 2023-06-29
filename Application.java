public class Application {
    private String appName;
    private String version;
    private Double dimension;
    private Phone phone;

    public Application(String appName, String version, double dimension) {
        this.appName = appName;
        this.version = version;
        this.dimension = dimension;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getDimension() {
        return dimension;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }




}
