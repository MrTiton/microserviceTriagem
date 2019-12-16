package projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projeto.entities.ResponseModel;
import projeto.entities.Triagem;
import projeto.repository.TriagemRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/triagens")
public class TriagemService {
	
	@Autowired
	private TriagemRepository triagemRepository;
	
	@PostMapping
	public @ResponseBody ResponseModel save (@RequestBody Triagem triagem) {
		try {
			this.triagemRepository.save(triagem);
			return new ResponseModel(1, "Registrada com sucesso");
			
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseModel update (@RequestBody Triagem triagem) {
		try {
			
			this.triagemRepository.save(triagem);
			return new ResponseModel(1, "Registrada com sucesso");
			
		} catch (Exception e) {
			return new ResponseModel(0, "Registrada com sucesso");
		}
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseModel delete (@PathVariable("id") Long id) {
		try {
			this.triagemRepository.deleteById(id);
			return new ResponseModel(1, "Registro excluido com sucesso");
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
    @GetMapping
    public @ResponseBody
    List<Triagem> findAll(){
        return this.triagemRepository.findAll();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Triagem> findById (@PathVariable("id") Long id){
		Optional<Triagem> triagem = this.triagemRepository.findById(id);
		
		if(triagem == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(triagem.get());
		}
	}
	
	

}
