package kz.library.task.ufuture.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String error;

    private String message;

    private String stackTrace;

}
