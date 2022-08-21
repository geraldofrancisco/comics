package com.thor.comics.rest;

import com.thor.comics.dto.ComicRequest;
import com.thor.comics.dto.ComicResponse;
import com.thor.comics.mapper.ComicMapper;
import com.thor.comics.service.ComicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;

import static com.thor.comics.constant.ComicConstant.API;
import static com.thor.comics.constant.ComicConstant.COVER_IMAGE_PATH;
import static com.thor.comics.constant.ComicConstant.DESCRIPTION;
import static com.thor.comics.constant.ComicConstant.NAME;
import static com.thor.comics.constant.ErrorConstant.COMIC_COVER_IMAGE_FILE_REQUIRED;
import static com.thor.comics.constant.RestConstant.DEFAULT_PAGE;
import static com.thor.comics.constant.RestConstant.DEFAULT_SIZE;
import static com.thor.comics.constant.RestConstant.PAGE;
import static com.thor.comics.constant.RestConstant.SIZE;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(API)
@Tag(name = NAME, description = DESCRIPTION)
@Validated
@RequiredArgsConstructor
public class ComicController {
    private final ComicService service;
    private final ComicMapper mapper;

    @GetMapping
    @ResponseStatus(OK)
    public Mono<Page<ComicResponse>> list(
            @RequestParam(name = PAGE, defaultValue = DEFAULT_PAGE, required = false) int page,
            @RequestParam(name = SIZE, defaultValue = DEFAULT_SIZE, required = false) int size
    ) {
        return this.service.findAll(of(page, size));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<ComicResponse> insert(@RequestBody ComicRequest request) {
        return this.service.insert(request)
                .map(this.mapper::toResponse);
    }

    @PatchMapping(COVER_IMAGE_PATH)
    @ResponseStatus(ACCEPTED)
    public Mono<Void> changeCoverImage(
            @PathVariable String comic,
            @NotNull(message = COMIC_COVER_IMAGE_FILE_REQUIRED) @RequestParam MultipartFile file
    ) {
        return null;
    }
}
