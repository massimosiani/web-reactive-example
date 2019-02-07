package io.github.massimosiani.webreactiveexample.controllers;

import io.github.massimosiani.webreactiveexample.domain.MyObject;
import io.github.massimosiani.webreactiveexample.repository.MyObjectService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class ObjectController {

    private final MyObjectService myObjectService;

    public ObjectController(MyObjectService myObjectService) {
        this.myObjectService = myObjectService;
    }

    @GetMapping("/objects")
    public ResponseEntity<List<MyObject>> list() {
        return ResponseEntity.ok(myObjectService.findAll());
    }

    @GetMapping("/objects/flux")
    public Flux<MyObject> listFlux() {
        long start = System.currentTimeMillis();
        return myObjectService.findAllFlux()
                .map(o -> o.setMillis(System.currentTimeMillis() - start));
    }

    @GetMapping("/objects/sse")
    public Flux<ServerSentEvent<MyObject>> listSSE() {
        long start = System.currentTimeMillis();
        return myObjectService.findAllFlux()
                .map(o -> o.setMillis(System.currentTimeMillis() - start))
                .map(o -> ServerSentEvent.builder(o).build());
    }

    @GetMapping(value = "/objects/sse/annotated", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MyObject> listSSEWithAnnotation() {
        long start = System.currentTimeMillis();
        return myObjectService.findAllFlux()
                .map(o -> o.setMillis(System.currentTimeMillis() - start));
    }
}
