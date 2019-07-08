package br.com.outspoken.apiproject.controllers;

import br.com.outspoken.apiproject.model.Orgao;
import br.com.outspoken.apiproject.service.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orgao")
public class OrgaoController {

    @Autowired
    private OrgaoService orgaoService;

    @PostMapping(value = "inserir")
    public ResponseEntity<Orgao> inserindoOrgao(@RequestBody Orgao orgao){
        orgaoService.salvarOrgao(orgao);
        return new ResponseEntity("Orgao salvo com sucesso",HttpStatus.OK);
    }

    @DeleteMapping(value = "deletar/{id}")
    public ResponseEntity<Orgao> deletandoOrgao(@PathVariable Long id){
        orgaoService.deletarOrgao(id);
        return new ResponseEntity( "Deletado com sucesso",HttpStatus.OK);
    }

    @PutMapping(value = "editar/{id}")
    public ResponseEntity<Orgao> editarOrgao(@PathVariable Long id, @RequestBody Orgao orgao){
        return new ResponseEntity(orgaoService.editarOrgao(orgao), HttpStatus.OK);
    }

    @GetMapping(value = "buscar/{id}")
    public ResponseEntity<Orgao> buscarOrgao(@PathVariable Long id){
        return new ResponseEntity(orgaoService.buscarOrgao(id), HttpStatus.OK);
    }
}
