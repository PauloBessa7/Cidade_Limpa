package com.cidade.limpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cidade.limpa.model.OcorrenciaModel;

public interface OcorrenciaRepository  extends JpaRepository<OcorrenciaModel, Long>{
    
}
