package com.thor.comics.exception.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static com.thor.comics.constant.ExceptionResponseConstant.MESSAGES;
import static com.thor.comics.constant.ExceptionResponseConstant.STATUS;
import static com.thor.comics.constant.ExceptionResponseConstant.TIMESTAMP;
import static com.thor.comics.constant.PatternConstant.DATE_TIME_PATTERN;

@Builder
@Data
public class ExceptionResponse {
    @Schema(description = STATUS)
    private Integer status;

    @Schema(description = TIMESTAMP)
    @Builder.Default
    @JsonFormat(pattern = DATE_TIME_PATTERN)
    private LocalDateTime timestamp = LocalDateTime.now();

    @Schema(description = MESSAGES)
    private List<ExceptionFieldError> messages;
}
