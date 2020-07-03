package bit;


public class Query {
    private String benA;
    private String benC;
    private String oA;
    private String oC;

    public String getBenA() {
        return benA;
    }

    public void setBenA(String benA) {
        this.benA = benA;
    }

    public String getBenC() {
        return benC;
    }

    public void setBenC(String benC) {
        this.benC = benC;
    }

    public String getoA() {
        return oA;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public String getoC() {
        return oC;
    }

    public void setoC(String oC) {
        this.oC = oC;
    }

    @Override
    public String toString() {
        return "Query{" +
                "benA='" + benA + '\'' +
                ", benC='" + benC + '\'' +
                ", oA='" + oA + '\'' +
                ", oC='" + oC + '\'' +
                '}';
    }
}
