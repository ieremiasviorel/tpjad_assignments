package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import utils.Timing;
import utils.TimingFactory;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ParallelController extends Controller {
    @Inject
    TimingFactory tmf;

    public CompletionStage<Result> index() {

        CompletableFuture<Timing> call1 = tmf.timedRequest("http://www.google.com");
        CompletableFuture<Timing> call2 = tmf.timedRequest("http://www.yahoo.com");
        CompletableFuture<Timing> call3 = tmf.timedRequest("http://www.bing.com");

        List<CompletableFuture<Timing>> allFutures = Arrays.asList(call1, call2, call3);

        return CompletableFuture.allOf(call1, call2, call3).thenApply(avoid -> ok(views.html.parallel.render(allFutures)));
    }
}

