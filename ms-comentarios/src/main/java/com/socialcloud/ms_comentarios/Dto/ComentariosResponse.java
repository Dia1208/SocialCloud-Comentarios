package com.socialcloud.ms_comentarios.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ComentariosResponse {

    private Long id;
    private Long publicacionId;
    private Long usuarioId;
    private String contenido;
    private LocalDateTime fechaCreacion;
}
