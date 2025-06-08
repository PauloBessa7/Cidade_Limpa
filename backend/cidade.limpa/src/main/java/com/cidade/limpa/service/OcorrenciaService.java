package com.cidade.limpa.service;

import com.cidade.limpa.model.OcorrenciaModel;
import com.cidade.limpa.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    // Listar todas as ocorrências, ordenadas pelas curtidas (decrescente)
    public List<OcorrenciaModel> getAllOcorrencias() {
        List<OcorrenciaModel> ocorrencias = repository.findAll();
        ocorrencias.sort((o1, o2) -> Integer.compare(o2.getCurtidas(), o1.getCurtidas()));
        return ocorrencias;
    }

    // Criar uma nova ocorrência
    public OcorrenciaModel createOcorrencia(OcorrenciaModel ocorrencia) {
        return repository.save(ocorrencia);
    }

    // Buscar ocorrência por ID
    public Optional<OcorrenciaModel> findOcorrenciaById(Long id) {
        return repository.findById(id);
    }

    // Dar "curtir" na ocorrência
    public OcorrenciaModel likeOcorrencia(Long id) {
        Optional<OcorrenciaModel> ocorrenciaOpt = findOcorrenciaById(id);
        if (ocorrenciaOpt.isPresent()) {
            OcorrenciaModel ocorrencia = ocorrenciaOpt.get();
            ocorrencia.setCurtidas(ocorrencia.getCurtidas() + 1);
            return repository.save(ocorrencia);
        } else {
            throw new RuntimeException("Ocorrência não encontrada");
        }
    }

    // Marcar ocorrência como concluída
    public OcorrenciaModel concluirOcorrencia(Long id) {
        Optional<OcorrenciaModel> ocorrenciaOpt = findOcorrenciaById(id);
        if (ocorrenciaOpt.isPresent()) {
            OcorrenciaModel ocorrencia = ocorrenciaOpt.get();
            ocorrencia.setStatusConcluido(true);
            return repository.save(ocorrencia);
        } else {
            throw new RuntimeException("Ocorrência não encontrada");
        }
    }
}
