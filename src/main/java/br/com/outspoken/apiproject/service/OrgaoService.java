package br.com.outspoken.apiproject.service;

import br.com.outspoken.apiproject.model.Documento;
import br.com.outspoken.apiproject.model.Orgao;
import br.com.outspoken.apiproject.repository.DocumentoRepository;
import br.com.outspoken.apiproject.repository.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository orgaoRepository;

    @Transactional
    public Orgao salvarOrgao(Orgao orgao) {
        Orgao salvandoOrgao = orgaoRepository.save(orgao);
        return orgao;
    }

    public void deletarOrgao(Long id){
       orgaoRepository.deleteById(id);
    }

    public Orgao buscarOrgao(Long id){
        return orgaoRepository.findById(id).get();
    }
    public Orgao editarOrgao(Orgao orgao){
        return orgaoRepository.save(orgao);
    }

}
