package com.thor.comics.mapper;

import com.thor.comics.document.ComicDocument;
import com.thor.comics.dto.ComicRequest;
import com.thor.comics.dto.ComicResponse;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ComicMapper {
    ComicResponse toResponse(ComicDocument document);
    List<ComicResponse> toResponse(List<ComicDocument> list);

    ComicDocument toDocument(ComicRequest request);
}
