package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {
	
	private Integer id;
	@NotNull(message="Sala não pode ser nula")
	private Integer salaId;
	@DateTimeFormat(pattern="HH:mm")
	@NotNull(message="Horário não pode ser nula")
	private LocalTime horario;
	@NotNull(message="Filme não pode ser nula")
	private Integer filmeId;
	
	public Sessao toSessao(FilmeDao filmeDao, SalaDao salaDao) {
		Sala sala = salaDao.findOne(salaId);
		Filme filme = filmeDao.findOne(filmeId);
		
		return new Sessao(horario, filme, sala);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFilmeId() {
		return filmeId;
	}
	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}
	public Integer getSalaId() {
		return salaId;
	}
	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

}
