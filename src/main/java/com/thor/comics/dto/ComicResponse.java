package com.thor.comics.dto;

import com.thor.comics.enumerable.ComicType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComicResponse {
    public String id;
    private String name;
    private ComicType type;
    private String coverImage;
    private LocalDateTime createdDate;
}
