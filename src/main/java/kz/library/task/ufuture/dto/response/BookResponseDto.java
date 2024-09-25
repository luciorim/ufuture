package kz.library.task.ufuture.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class BookResponseDto {

    private UUID id;

    private String title;

    private String author;

    private String description;

    private BigDecimal price;
}
