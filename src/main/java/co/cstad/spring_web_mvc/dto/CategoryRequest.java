package co.cstad.spring_web_mvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank
        @Size(max=40)
        String name,
        String description
) {

}
