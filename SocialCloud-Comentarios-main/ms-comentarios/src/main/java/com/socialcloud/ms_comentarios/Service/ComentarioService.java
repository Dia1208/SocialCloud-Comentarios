package com.socialcloud.ms_comentarios.Service;

import com.socialcloud.ms_comentarios.Dto.ComentariosRequest;
import com.socialcloud.ms_comentarios.Dto.ComentariosResponse;
import com.socialcloud.ms_comentarios.Entity.Comentario;
import com.socialcloud.ms_comentarios.Repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentariosResponse crear(ComentariosRequest request) {
        Comentario comentario = Comentario.builder()
                .publicacionId(request.getPublicacionId())
                .usuarioId(request.getUsuarioId())
                .contenido(request.getContenido())
                .fechaCreacion(LocalDateTime.now())
                .build();

        return convertir(comentarioRepository.save(comentario));
    }

    public List<ComentariosResponse> listar() {
        return comentarioRepository.findAll()
                .stream()
                .map(this::convertir)
                .toList();
    }

    public ComentariosResponse buscarPorId(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

        return convertir(comentario);
    }

    public List<ComentariosResponse> listarPorPublicacion(Long publicacionId) {
        return comentarioRepository.findByPublicacionId(publicacionId)
                .stream()
                .map(this::convertir)
                .toList();
    }

    public List<ComentariosResponse> listarPorUsuario(Long usuarioId) {
        return comentarioRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::convertir)
                .toList();
    }

    public ComentariosResponse actualizar(Long id, ComentariosRequest request) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

        comentario.setPublicacionId(request.getPublicacionId());
        comentario.setUsuarioId(request.getUsuarioId());
        comentario.setContenido(request.getContenido());

        return convertir(comentarioRepository.save(comentario));
    }

    public void eliminar(Long id) {
        if (!comentarioRepository.existsById(id)) {
            throw new RuntimeException("Comentario no encontrado");
        }

        comentarioRepository.deleteById(id);
    }

    private ComentariosResponse convertir(Comentario comentario) {
        return ComentariosResponse.builder()
                .id(comentario.getId())
                .publicacionId(comentario.getPublicacionId())
                .usuarioId(comentario.getUsuarioId())
                .contenido(comentario.getContenido())
                .fechaCreacion(comentario.getFechaCreacion())
                .build();
    }
}
