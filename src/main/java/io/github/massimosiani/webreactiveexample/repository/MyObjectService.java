package io.github.massimosiani.webreactiveexample.repository;

import io.github.massimosiani.webreactiveexample.domain.MyObject;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Service
public class MyObjectService {

    public List<MyObject> findAll() {
        return Arrays.asList(
                new MyObject("first 1", "first 2"),
                new MyObject("second 1", "second 2"),
                new MyObject("third 1", "third 2")
        );
    }

    public Flux<MyObject> findAllFlux() {
        return Flux.just(
                new MyObject("first 1", "first 2"),
                new MyObject("second 1", "second 2"),
                new MyObject("third 1", "third 2")
        )
                .delayElements(Duration.ofSeconds(1));
    }
}
