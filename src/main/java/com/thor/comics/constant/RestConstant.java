package com.thor.comics.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RestConstant {
    public static final String PAGE = "page";
    public static final String SIZE = "size";
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_SIZE = "20";
    public static final String STATUS_OK = "200";
    public static final String STATUS_OK_DESCRIPTION = "Successful operation";
    public static final String STATUS_CREATED = "201";
    public static final String STATUS_CREATED_DESCRIPTION = "Entity created";
    public static final String STATUS_ACCEPTED = "202";
    public static final String STATUS_ACCEPTED_DESCRIPTION = "Entity accepted";
    public static final String STATUS_NO_CONTENT = "204";
    public static final String STATUS_NO_CONTENT_DESCRIPTION = "No content";
    public static final String STATUS_BAD_REQUEST = "400";
    public static final String STATUS_BAD_REQUEST_DESCRIPTION = "Bad request";
    public static final String STATUS_NOT_FOUND = "404";
    public static final String STATUS_NOT_FOUND_DESCRIPTION = "Entity not found";
}
