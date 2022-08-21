package com.thor.comics.document;

import com.thor.comics.enumerable.ComicType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comic")
public class ComicDocument {
    @Id
    private String id;

    @Field("nome")
    private String name;

    @Field("tipo")
    private ComicType type;

    @Field("imagemCapa")
    private String coverImage;

    @Builder.Default
    @Field("dataHoraCriacao")
    private LocalDateTime createdDate = LocalDateTime.now();
}
