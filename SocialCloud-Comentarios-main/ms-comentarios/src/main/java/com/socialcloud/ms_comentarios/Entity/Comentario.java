package com.socialcloud.ms_comentarios.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long publicacionId;

    private Long usuarioId;

    @Column(nullable = false, length = 300)
    private String contenido;

    private LocalDateTime fechaCreacion;
}
