package utils;

import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class TimingFactory implements WSBodyReadables, WSBodyWritables, TimingFactoryInterface {
    @Inject
    WSClient ws;

    static final DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public CompletableFuture<Timing> timedRequest(String url) {
        long start = System.currentTimeMillis();
        String startStr = formatter.format(new Date(start));

        CompletableFuture<WSResponse> response = (CompletableFuture<WSResponse>) ws.url(url).get();

        return response.thenApply(new Function<WSResponse, Timing>() {
            @Override
            public Timing apply(WSResponse wsResponse) {
                long end = System.currentTimeMillis();
                long latency = end - start;
                String endStr = formatter.format(new Date(end));
                return new Timing(url, startStr, endStr, latency);
            }
        });
    }
}
