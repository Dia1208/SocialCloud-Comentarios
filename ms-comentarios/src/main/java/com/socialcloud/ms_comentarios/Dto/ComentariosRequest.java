package com.socialcloud.ms_comentarios.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentariosRequest {

    @NotNull(message = "El publicacionId es obligatorio")
    private Long publicacionId;

    @NotNull(message = "El usuarioId es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El contenido es obligatorio")
    private String contenido;
}
