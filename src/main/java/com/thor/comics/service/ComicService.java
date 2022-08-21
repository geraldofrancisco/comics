package com.thor.comics.service;

import com.thor.comics.document.ComicDocument;
import com.thor.comics.dto.ComicRequest;
import com.thor.comics.dto.ComicResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface ComicService {
    Mono<ComicDocument> insert(ComicRequest request);
    Mono<Page<ComicResponse>> findAll(Pageable pageable);
}
