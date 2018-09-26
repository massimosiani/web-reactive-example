package io.github.massimosiani.webreactiveexample.controllers;

import io.github.massimosiani.webreactiveexample.domain.MyObject;
import io.github.massimosiani.webreactiveexample.repository.MyObjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ObjectController {

    private final MyObjectRepository myObjectRepository;

    public ObjectController(MyObjectRepository myObjectRepository) {
        this.myObjectRepository = myObjectRepository;
    }

    @GetMapping("/objects")
    public Flux<MyObject> list() {
        long start = System.currentTimeMillis();
        return myObjectRepository.findAll()
                .map(o -> o.setMillis(System.currentTimeMillis() - start));
    }
}
