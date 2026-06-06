package com.socialcloud.ms_comentarios.Repository;

import com.socialcloud.ms_comentarios.Entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByPublicacionId(Long publicacionId);

    List<Comentario> findByUsuarioId(Long usuarioId);
}
