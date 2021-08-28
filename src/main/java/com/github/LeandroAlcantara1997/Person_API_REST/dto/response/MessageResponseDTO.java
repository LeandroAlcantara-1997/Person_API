package com.github.LeandroAlcantara1997.Person_API_REST.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private String message;
}