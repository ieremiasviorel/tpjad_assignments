package utils;

public class Timing {
    public String url;
    public long latency;

    public Timing(String url, long latency) {
        this.url = url;
        this.latency = latency;
    }
}
