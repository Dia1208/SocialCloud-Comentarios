package com.socialcloud.ms_comentarios.Controller;

import com.socialcloud.ms_comentarios.Dto.ComentariosRequest;
import com.socialcloud.ms_comentarios.Dto.ComentariosResponse;
import com.socialcloud.ms_comentarios.Service.ComentarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@RequiredArgsConstructor
public class ComentariosController {

    private final ComentarioService comentarioService;

    @PostMapping
    public ComentariosResponse crear(@Valid @RequestBody ComentariosRequest request) {
        return comentarioService.crear(request);
    }

    @GetMapping
    public List<ComentariosResponse> listar() {
        return comentarioService.listar();
    }

    @GetMapping("/{id}")
    public ComentariosResponse buscarPorId(@PathVariable Long id) {
        return comentarioService.buscarPorId(id);
    }

    @GetMapping("/publicacion/{publicacionId}")
    public List<ComentariosResponse> listarPorPublicacion(@PathVariable Long publicacionId) {
        return comentarioService.listarPorPublicacion(publicacionId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<ComentariosResponse> listarPorUsuario(@PathVariable Long usuarioId) {
        return comentarioService.listarPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public ComentariosResponse actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ComentariosRequest request) {
        return comentarioService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        comentarioService.eliminar(id);
        return "Comentario eliminado correctamente";
    }
}
