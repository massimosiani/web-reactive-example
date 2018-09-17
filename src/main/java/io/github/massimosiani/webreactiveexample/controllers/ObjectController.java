package io.github.massimosiani.webreactiveexample.controllers;

import io.github.massimosiani.webreactiveexample.repository.ObjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequestMapping("")
@RestController
public class ObjectController {
    private final ObjectRepository objectRepository;

    public ObjectController(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @GetMapping("/objects")
    public Flux<Object> list() {
        return objectRepository.findAll();
    }
}
