package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.jogador.Jogador;
import br.com.codenation.time.Time;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private final Set<Time> times = new HashSet<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Time novoTime = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		if(existeTimeComId(id)) {
			throw new IdentificadorUtilizadoException();
		}
		times.add(novoTime);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Jogador novoJogador = new Jogador(id, nome, dataNascimento, nivelHabilidade, salario);
		Time timeOptional = times.stream()
				.filter(time -> time.getId().equals(idTime))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);
		timeOptional.adicionarJogador(novoJogador);
	}

	public void definirCapitao(Long idJogador) {
		times.stream()
				.filter(time -> time.buscarJogador(idJogador).isPresent())
				.findAny()
				.orElseThrow(JogadorNaoEncontradoException::new)
				.setIdCapitao(idJogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		return times.stream()
				.filter(time -> time.getId().equals(idTime))
				.findAny()
				.orElseThrow(TimeNaoEncontradoException::new)
				.getCapitao()
				.orElseThrow(CapitaoNaoInformadoException::new);
	}

	public String buscarNomeJogador(Long idJogador) {
		return getJogadoresTodosTimes()
				.stream()
				.filter(jogador -> jogador.ehIdDoJogador(idJogador))
				.findAny()
				.orElseThrow(JogadorNaoEncontradoException::new)
				.getNome();
	}

	public String buscarNomeTime(Long idTime) {
		return times.stream()
			.filter(time -> time.getId().equals(idTime))
			.findFirst()
			.orElseThrow(TimeNaoEncontradoException::new)
			.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		final Time time = times.stream()
				.filter(time1 -> time1.getId().equals(idTime))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);
		return time.getIdJogadores();
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		return times.stream().filter(time -> time.getId().equals(idTime))
				.findFirst()
				.map(Time::buscarMelhorJogador)
				.orElseThrow(TimeNaoEncontradoException::new);
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		return times.stream().filter(time -> time.getId().equals(idTime))
				.findFirst()
				.map(Time::buscarJogadorMaisVelho)
				.orElseThrow(TimeNaoEncontradoException::new);
	}

	public List<Long> buscarTimes() {
		return times.stream()
				.sorted(Comparator.comparingLong(Time::getId))
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		return times.stream().filter(time -> time.getId().equals(idTime))
				.findFirst()
				.map(Time::buscarJogadorMaiorSalario)
				.orElseThrow(TimeNaoEncontradoException::new);
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return getJogadoresTodosTimes()
				.stream().filter(jogador -> jogador.ehIdDoJogador(idJogador))
				.findAny()
				.orElseThrow(JogadorNaoEncontradoException::new)
				.getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		return times.stream()
				.map(time -> time.buscarJogadoresOrdenadoHabilidade(top))
				.reduce((List<Long> lista1, List<Long> list2) -> {
					lista1.addAll(list2);
					return lista1;
				})
				.orElse(new ArrayList<>());
	}

	private boolean existeTimeComId(Long idTime) {
		return times.stream().anyMatch(time -> time.getId().equals(idTime));
	}

	private List<Jogador> getJogadoresTodosTimes() {
		return times.stream()
				.map(Time::getJogadores)
				.reduce((List<Jogador> lista1, List<Jogador> lista2) -> {
					lista1.addAll(lista2);
					return lista1;
				})
				.orElse(new ArrayList<>());
	}

}
