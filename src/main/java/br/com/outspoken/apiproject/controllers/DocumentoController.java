package br.com.outspoken.apiproject.controllers;

import br.com.outspoken.apiproject.model.Documento;
import br.com.outspoken.apiproject.repository.DocumentoRepository;
import br.com.outspoken.apiproject.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

	@Autowired
	private DocumentoService documentoService;

	@GetMapping(value = "/buscando")
	ResponseEntity<LocalDateTime> testeMetodos() {
		LocalDateTime agora = LocalDateTime.now();
		//List<String> nomes = Arrays.asList("lazaro", "asd", "testando os métodos");
		 return new ResponseEntity<>(agora, HttpStatus.OK);
	}

	@GetMapping(value = "/buscar")
	ResponseEntity<List<Documento>> testandoMetodos() {
		return new ResponseEntity<>(documentoService.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping("/buscaentredatas")
	private ResponseEntity buscaEntreDatas(@RequestParam String dataInicial, @RequestParam String dataFinal){
		LocalDate dataInicialLocalDate = LocalDate.parse(dataInicial);
		LocalDate dataFinalLocalDate = LocalDate.parse(dataFinal);
		List<Documento> Teste = documentoService.listaPronta(dataInicialLocalDate,dataFinalLocalDate);
		return new ResponseEntity(Teste,HttpStatus.OK);
	}

	@PostMapping(value = "/inserir")
	public ResponseEntity salvarDocumento(@RequestBody Documento documento){
		boolean isDataFutura =  documentoService.validarDataDocumentoFutura(documento.getData());
		if(isDataFutura){
			documentoService.salvarDocumento(documento);
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity("Não é possível salvar o documento com a data futura",HttpStatus.BAD_REQUEST);
		}
	};

	@PutMapping(value = "/editando")
	public ResponseEntity<Documento> atualizandoDocumento(@RequestBody Documento documento) {
		//documentoRepository.save(documento);
		return new ResponseEntity(documento, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletando/{id}")
	public ResponseEntity deletarDocumento(@PathVariable Long id){
		boolean isDocumentoExistente = documentoService.verificaDocumentoExistente(id);
		if(isDocumentoExistente){
			documentoService.deletarDocumento(id);
			return  new ResponseEntity("Deletado com sucesso",HttpStatus.OK);
		}else {
			return  new ResponseEntity("Id não encontrado",HttpStatus.NOT_FOUND);
		}
	}
}
