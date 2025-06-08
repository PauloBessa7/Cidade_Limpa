package com.cidade.limpa.controller;

import com.cidade.limpa.model.OcorrenciaModel;
import com.cidade.limpa.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    // GET - Listar todas as ocorrências
    @GetMapping
    public List<OcorrenciaModel> listarOcorrencias() {
        return ocorrenciaService.getAllOcorrencias();
    }

    // POST - Criar uma nova ocorrência
    @PostMapping
    public OcorrenciaModel criarOcorrencia(@RequestBody OcorrenciaModel ocorrencia) {
        return ocorrenciaService.createOcorrencia(ocorrencia);
    }

    // GET - Buscar ocorrência por ID
    @GetMapping("/{id}")
    public OcorrenciaModel buscarOcorrenciaPorId(@PathVariable Long id) {
        return ocorrenciaService.findOcorrenciaById(id)
                .orElseThrow(() -> new RuntimeException("Ocorrência não encontrada com ID: " + id));
    }

    // PATCH - Dar "curtir" na ocorrência
    @PatchMapping("/{id}/curtir")
    public OcorrenciaModel curtirOcorrencia(@PathVariable Long id) {
        return ocorrenciaService.likeOcorrencia(id);
    }

    // PATCH - Marcar ocorrência como "concluída"
    @PatchMapping("/{id}/concluir")
    public OcorrenciaModel concluirOcorrencia(@PathVariable Long id) {
        return ocorrenciaService.concluirOcorrencia(id);
    }
}
