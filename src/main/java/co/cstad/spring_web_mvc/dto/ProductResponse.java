package co.cstad.spring_web_mvc.dto;

import java.util.UUID;

public record ProductResponse(
        String uuid,
        String name,
        Double price,
        Integer qty
    ) {
}
