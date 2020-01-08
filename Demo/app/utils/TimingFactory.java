package utils;

import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class TimingFactory implements WSBodyReadables, WSBodyWritables, TimingFactoryInterface {
    @Inject
    WSClient ws;

    public CompletableFuture<Timing> timedRequest(String url) {
        long start = System.currentTimeMillis();

        CompletableFuture<WSResponse> response = (CompletableFuture<WSResponse>) ws.url(url).get();

        return response.thenApply(new Function<WSResponse, Timing>() {
            @Override
            public Timing apply(WSResponse wsResponse) {
                long latency = System.currentTimeMillis() - start;
                return new Timing(url, latency);
            }
        });
    }
}
