package projeto.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Triagem {

	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	private Date data_triagem;
	
	//plastico, vidro, papel, papelão, sucata, aluminio, ferro, blocos de isopor(não bandejinha), equipamentos de informatica, eletronicos, capas de CD, fitas VHS, K7
	@Size(max = 100)
	private String tipo;
	
	private Integer quantidade;
	
	@NotNull
	private Integer cooperado_id;
	
	@Size(max = 100)
	private String repositorio;
	
//	private Double valor_kilo;		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData_Triagem() {
		return data_triagem;
	}

	public void setData_Triagem(Date data_triagem) {
		this.data_triagem = data_triagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getCooperado_id() {
		return cooperado_id;
	}

	public void setCooperado_id(Integer cooperado_id) {
		this.cooperado_id = cooperado_id;
	}

	public String getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(String repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triagem other = (Triagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}

//PostgreSQL
//CREATE TABLE triagem(
//		 id serial NOT NULL
//		, data_triagem date		
//		, tipo varchar(100)
//		, quantidade int
//		, cooperado_id int
//		, repositorio varchar(100) 
//		,  PRIMARY KEY (id)
//	)
