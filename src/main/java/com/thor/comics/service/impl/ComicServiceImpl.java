package com.thor.comics.service.impl;

import com.thor.comics.document.ComicDocument;
import com.thor.comics.dto.ComicRequest;
import com.thor.comics.dto.ComicResponse;
import com.thor.comics.exception.BusinessException;
import com.thor.comics.mapper.ComicMapper;
import com.thor.comics.repository.ComicRepository;
import com.thor.comics.service.ComicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.thor.comics.constant.ErrorConstant.COMIC_ALREADY_EXISTS;

@Service
@AllArgsConstructor
public class ComicServiceImpl implements ComicService {
    private ComicRepository repository;
    private ComicMapper mapper;

    @Override
    public Mono<ComicDocument> insert(ComicRequest request) {
        var document = this.mapper.toDocument(request);
        return this.repository.existsByNameIgnoreCaseAndType(request.getName(), request.getType())
                .flatMap(exists -> {
                    if (exists)
                        return Mono.error(new BusinessException(COMIC_ALREADY_EXISTS));
                    return this.repository.save(document);
                });
    }

    @Override
    public Mono<Page<ComicResponse>> findAll(Pageable pageable) {
        return this.repository.count()
                .flatMap(total ->
                        this.repository.findByIdNotNullOrderByNameAsc(pageable)
                                .collectList()
                                .map(list -> new PageImpl<>(this.mapper.toResponse(list), pageable, total))
                );
    }
}
