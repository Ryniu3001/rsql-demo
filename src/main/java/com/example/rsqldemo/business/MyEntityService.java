package com.example.rsqldemo.business;

import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyEntityService {

    private final MyEntityRepository repository;

    @Transactional
    public void add(MyEntity myEntity) {
        repository.save(myEntity);
    }

    @Transactional
    public void removeAll() {
        repository.deleteAll();
    }

    @Transactional
    public Page<MyEntity> findByRsql(String query, Pageable pageable) {
        return repository.findAll(RSQLJPASupport.toSpecification(query), pageable);
    }
}
