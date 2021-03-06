package br.com.sistemafjm.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class FichaTreino implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fichaId;

	@ManyToOne(fetch = FetchType.EAGER)
	private UsuarioModelo usuario;
	@ManyToOne(fetch = FetchType.EAGER)
	private InstrutorModelo instrutor;

	@Enumerated(EnumType.STRING)
	private FichaStatusEnum fichaAtual = FichaStatusEnum.Atual;

	@Enumerated(EnumType.STRING)
	private DivisaoTreinoEnum serie;
	private String dataInicial;
	private String dataFinal;

	@Enumerated(EnumType.STRING)
	private ObjetivoEnum objetivo;

	private String frequenciaSemanal;
	private String tempoDisponivel;

	@OneToMany(mappedBy = "ficha", fetch = FetchType.EAGER)
	private List<Exercicio_Aparelho> exerciciosAparelhos;

}
