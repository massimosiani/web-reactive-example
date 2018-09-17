package io.github.massimosiani.webreactiveexample.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends ReactiveCrudRepository<Object, String> {
}
