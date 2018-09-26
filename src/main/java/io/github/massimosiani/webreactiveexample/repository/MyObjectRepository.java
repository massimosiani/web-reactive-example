package io.github.massimosiani.webreactiveexample.repository;

import io.github.massimosiani.webreactiveexample.domain.MyObject;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Repository
public interface MyObjectRepository {

    default Flux<MyObject> findAll() {
        return Flux.just(
                new MyObject("first 1", "first 2"),
                new MyObject("second 1", "second 2"),
                new MyObject("third 1", "third 2")
        )
                .delayElements(Duration.ofSeconds(3));
    }
}
