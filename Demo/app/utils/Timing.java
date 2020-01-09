package utils;

public class Timing {
    public String url;
    public String start;
    public String end;
    public long latency;

    public Timing(String url, String start, String end, long latency) {
        this.url = url;
        this.start = start;
        this.end = end;
        this.latency = latency;
    }
}
