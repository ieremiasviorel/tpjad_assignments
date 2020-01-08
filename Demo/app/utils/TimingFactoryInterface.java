package utils;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;

@ImplementedBy(TimingFactory.class)
public interface TimingFactoryInterface {
    CompletionStage<Timing> timedRequest(String url);
}
