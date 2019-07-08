package br.com.outspoken.apiproject.service;

import br.com.outspoken.apiproject.model.Documento;
import br.com.outspoken.apiproject.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> buscarTodos(){
        return (List<Documento>) documentoRepository.findAll();
    }

    public Documento salvarDocumento(Documento documento){
        Documento salvandoDocumento = documentoRepository.save(documento);
        return documento;
    }

    public boolean deletarDocumento(Long id){
        try{
            documentoRepository.deleteById(id);
        }catch (Exception exemploDeException){
            return false;
        }
        return true;
    }

    public boolean verificaDocumentoExistente(Long id){
        boolean isDocumentoExistente = documentoRepository.existsById(id);
        if(isDocumentoExistente){
            return true;
        }else {
            return false;
        }
    }

    public boolean validarDataDocumentoFutura(LocalDate dataAtual) {
        LocalDate agora =  LocalDate.now();

        if (agora.isAfter(dataAtual)){
            return true;
        }else {
            return false;
        }
    }

    public List<Documento> listaPronta(LocalDate dataInicialLocalDate,LocalDate dataFinalLocalDate){

        List<Documento> listaProntinha = documentoRepository.buscaDocumentosPorData(dataInicialLocalDate,dataFinalLocalDate);

        return listaProntinha;
    };

}
