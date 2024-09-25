package kz.library.task.ufuture.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookRequestDto {
    @Size(min = 2, max = 255)
    @NotNull
    @JsonProperty("title")
    private String title;

    @NotNull
    @Size(min = 2, max = 255)
    private String author;

    @NotNull
    @Size(min = 2, max = 255)
    private String description;

    @Positive
    @NotNull
    private BigDecimal price;
}
