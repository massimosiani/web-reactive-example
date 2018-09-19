package io.github.massimosiani.webreactiveexample.controllers;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ObjectController {
    /*
    private final ObjectRepository objectRepository;

    public ObjectController(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @GetMapping("/objects")
    public Flux<Object> list() {
        return objectRepository.findAll();
    }
    */

    @GetMapping("/test")
    public Flux<MyObject> test() {
        long start = System.currentTimeMillis();
        return Flux.just(
                new MyObject("first 1", "first 2"),
                new MyObject("second 1", "second 2"),
                new MyObject("third 1", "third 2")
        )
                .delayElements(Duration.ofSeconds(3))
                .map(o -> o.setMillis(System.currentTimeMillis() - start));
    }

    public static class MyObject {
        String prop1;
        String prop2;
        long millis;

        public MyObject(String prop1, String prop2) {
            this.prop1 = prop1;
            this.prop2 = prop2;
        }

        public String getProp1() {
            return prop1;
        }

        public String getProp2() {
            return prop2;
        }

        public long getMillis() {
            return millis;
        }

        public MyObject setMillis(long millis) {
            this.millis = millis;
            return this;
        }
    }
}