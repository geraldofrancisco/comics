package com.thor.comics.repository;

import com.thor.comics.document.ComicDocument;
import com.thor.comics.enumerable.ComicType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ComicRepository extends ReactiveMongoRepository<ComicDocument, String> {
    Mono<Boolean> existsByNameIgnoreCaseAndType(String name, ComicType type);

    Flux<ComicDocument> findByIdNotNullOrderByNameAsc(Pageable pageable);
}
