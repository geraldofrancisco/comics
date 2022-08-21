package com.thor.comics.dto;

import com.thor.comics.enumerable.ComicType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComicRequest {
    private String name;
    private ComicType type;
}
