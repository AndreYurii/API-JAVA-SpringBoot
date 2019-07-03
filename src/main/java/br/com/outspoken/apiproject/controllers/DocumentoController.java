package br.com.outspoken.apiproject.controllers;

import br.com.outspoken.apiproject.model.Documento;
import br.com.outspoken.apiproject.repository.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

	@Autowired
	private TesteRepository testeRepository;

	@GetMapping(value = "/buscando")
	ResponseEntity<LocalDateTime> testeMetodos() {

		LocalDateTime agora = LocalDateTime.now();
		//List<String> nomes = Arrays.asList("lazaro", "asd", "testando os métodos");
		 return new ResponseEntity<>(agora, HttpStatus.OK);
	}

	@GetMapping(value = "/buscar")
	ResponseEntity<List<Documento>> testandoMetodos() {

		Documento capelelinTurismo = new Documento();

		capelelinTurismo.setId(1234L);
		capelelinTurismo.getData();
		capelelinTurismo.setNome("Joao");
		capelelinTurismo.setSalario(3400 * 3);
		capelelinTurismo.setInformacoes("Esse documento pertence ao Devops Joao Junior");

		Documento arquivoDeSalarios = new Documento();

		arquivoDeSalarios.setId(567L);
		arquivoDeSalarios.setNome("Mulambo");
		arquivoDeSalarios.getData();
		arquivoDeSalarios.setSalario(200 * 20);
		arquivoDeSalarios.setInformacoes("SalariosdevOps");

		Documento arquivoGerentes = new Documento();

		arquivoGerentes.setId(789L);
		arquivoGerentes.setNome("Gerente de projeto Fernando");
		arquivoGerentes.getData();
		arquivoGerentes.setSalario(3000 * 5);
		arquivoGerentes.setInformacoes("Informacoes pertinente ao Gerente de projetos Fernando da silva sauro");

		List<Documento> listaDeDocumentos = Arrays.asList(arquivoDeSalarios, arquivoGerentes, capelelinTurismo);

		return new ResponseEntity<>(listaDeDocumentos, HttpStatus.OK);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity salvarDocumento(@RequestBody Documento documento){
		System.out.println(documento.getNome()+documento.getSalario());

		testeRepository.save(documento);
		return null;
	};

	@PutMapping(value = "/editando")
	public String testeMetodosPUT() {
		return "Teste de troca";
	}
	
	@DeleteMapping(value = "/deletando")
	public boolean testeMetodosDELETE() {
		return true;
		
	}
}
