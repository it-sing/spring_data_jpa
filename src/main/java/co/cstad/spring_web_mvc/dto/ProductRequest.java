package co.cstad.spring_web_mvc.dto;

import jakarta.validation.constraints.*;

public record ProductRequest(
        @NotBlank
        @Size(max = 40)
        String name,
        @Positive
        @NotNull
        Double price,
        @Positive
        @NotNull
        @Max(100)
        Integer qty
) {

}
