package com.agenda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.agenda.model.Contato;

import jakarta.transaction.Transactional;



public interface IContatoRepository extends JpaRepository<Contato, Long>, JpaSpecificationExecutor<Contato> {

		@Transactional
	    @Modifying
	    @Query("UPDATE Contato c SET c.favorito = :favorito WHERE c.id = :id")
	    int atualizarFavorito(Long id, String favorito);
		
		@Transactional
	    @Modifying
	    @Query("UPDATE Contato c SET c.ativo = :ativo WHERE c.id = :id")
	    int inativarContato(Long id, String ativo);
		
	    @Query("select c from Contato c WHERE c.celular = :celular")
	    Optional<Contato> findByCelular(String celular);
	    
	    @Query("select c from Contato c WHERE c.ativo = 'S' ")
	    List<Contato> findAtivos();
}
