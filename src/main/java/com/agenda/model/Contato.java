package com.agenda.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "cadastro")
public class Contato implements Serializable {


	private static final long serialVersionUID = -3447935574164688843L;

	
	public Contato(Long id){
		this.id = id;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contato_id")
    private Long id;
    
	@Column(name = "contato_nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "contato_email", length = 255, nullable = false)
	private String email;

	@Column(name = "contato_celular", length = 11, nullable = false)
	private String celular;

	@Column(name = "contato_telefone", length = 10, nullable = false)
	private String telefone;

	@Column(name = "contato_sn_favorito", length = 1, nullable = false)
	private String favorito;

	@Column(name = "contato_sn_ativo", length = 1, nullable = false)
	private String ativo;

	@Column(name = "contato_dh_cad", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime dhCad;
	
}
