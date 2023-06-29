public class Phone {
    private String brand;
    private String model;
    private String serialNo;
    private Double capaticy;
    private String operationSytem;

    public Phone(String brand, String model, String serialNo, double capaticy, String operationSytem) {
        this.brand = brand;
        this.model = model;
        this.serialNo = serialNo;
        this.capaticy = capaticy;
        this.operationSytem = operationSytem;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Double getCapaticy() {
        return capaticy;
    }

    public void setCapaticy(double capaticy) {
        this.capaticy = capaticy;
    }

    public String getOperationSytem() {
        return operationSytem;
    }

    public void setOperationSytem(String operationSytem) {
        this.operationSytem = operationSytem;
    }

    @Override
    public String toString() {
        return "Phone : " +
                "Marka= '" + brand + '\'' +
                ", Model= '" + model + '\'' +
                ", Seri No= '" + serialNo + '\'' +
                ", Kapasite= " + capaticy +
                ", İşletim Sistemi= '" + operationSytem + '\'' ;

    }
}