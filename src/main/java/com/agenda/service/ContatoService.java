package com.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agenda.enums.Status;
import com.agenda.model.Contato;
import com.agenda.repository.IContatoRepository;

@Service
@Transactional
public class ContatoService {

	@Autowired
	private IContatoRepository contatoRepository;

	@Transactional
	public Contato create(Contato contato) {
		if (contato.getNome() != null && (contato.getTelefone() != null || contato.getEmail() != null)) {
			if (this.contatoRepository.findByCelular(contato.getCelular()).isEmpty()) {
				contato.setAtivo(Status.S.name());
				contato.setFavorito(Status.N.name());
				return this.contatoRepository.save(contato);
			}
		}
		return null;
	}

	@Transactional
	public void update(Contato contato) {
		this.contatoRepository.save(contato);
	}

	public void delete(Long idContato) {
		this.contatoRepository.inativarContato(idContato, Status.N.name());
	}

	@Transactional
	public List<Contato> findAll() {
		return this.contatoRepository.findAtivos();
	}

	@Transactional
	public Optional<Contato> findOne(Long idContato) {

		return this.contatoRepository.findById(idContato);

	}

	@Transactional
	public Contato favoritar(Long id) {
		int idRetorno = this.contatoRepository.atualizarFavorito(id, Status.S.name());
		
		return new Contato(Long.valueOf(idRetorno));
	}
}
