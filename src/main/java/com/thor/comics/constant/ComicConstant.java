package com.thor.comics.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ComicConstant {
    public static final String API = "/api/v1/comic";
    public static final String NAME = "Comic API";
    public static final String DESCRIPTION = "Endpoint de quadrinhos";
    public static final String COVER_IMAGE_PATH = "/{comic}/changeCoverImage";

}
