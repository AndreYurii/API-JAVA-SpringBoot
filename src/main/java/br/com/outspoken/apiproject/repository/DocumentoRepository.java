package br.com.outspoken.apiproject.repository;

import br.com.outspoken.apiproject.model.Documento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface DocumentoRepository extends CrudRepository<Documento, Long>{

    @Query("SELECT d FROM Documento d WHERE d.data BETWEEN  ?1 and ?2")
    List<Documento> buscaDocumentosPorData(LocalDate dataInicial, LocalDate dataFinal);

}
