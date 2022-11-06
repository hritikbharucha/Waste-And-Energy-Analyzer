public class DataType {
    private String type;
    private String data1;
    private String data2;

    public DataType(String type, String data1, String data2) {
        this.type = type;
        this.data1 = data1;
        this.data2 = data2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }
}
