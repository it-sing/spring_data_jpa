package co.cstad.spring_web_mvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductEditRequest(
        @NotBlank
        String name,
        @Positive
        @NotNull
        Double price
) {

}
