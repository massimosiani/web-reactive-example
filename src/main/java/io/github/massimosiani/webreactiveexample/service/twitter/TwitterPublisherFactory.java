package io.github.massimosiani.webreactiveexample.service.twitter;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class TwitterPublisherFactory {

    public Publisher<Object> publisher() {
        return Flux.create(null);
    }
}
