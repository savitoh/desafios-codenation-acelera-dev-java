package br.com.codenation.time;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.jogador.Jogador;

public class Time {
    
    private final Long id;

    private final String nome; 
    
    private final LocalDate dataCriacao;

    private final String corUniformePrincipal; 
    
    private final String corUniformeSecundario;

    private final Set<Jogador> jogadores;

    private Long idCapitao;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
            String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        this.jogadores = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Long> getIdJogadores() {
        return jogadores.stream().map(Jogador::getId).collect(Collectors.toList());
    }

    public List<Jogador> getJogadores() {
        return new ArrayList<>(jogadores);
    }

    public void setIdCapitao(Long idCapitao) {
        this.idCapitao = idCapitao;
    }

    public void adicionarJogador(Jogador jogador) {
        if(buscarJogador(jogador.getId()).isPresent()) {
            throw new IdentificadorUtilizadoException();
        }
        jogadores.add(jogador);
    }

    public Optional<Jogador> buscarJogador(Long idJogador) {
        return jogadores.stream().filter(jogador -> jogador.ehIdDoJogador(idJogador)).findAny();
    }

    public Optional<Long> getCapitao() {
        return Optional.ofNullable(this.idCapitao);
    }

    public Long buscarJogadorMaisVelho() {
        return jogadores.stream()
                .sorted(Comparator.comparingInt(Jogador::comparatorIdade).reversed().thenComparing(Jogador::getId))
                .findFirst()
                .get()
                .getId();
    }

    public Long buscarJogadorMaiorSalario() {
        return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getSalario).reversed().thenComparing(Jogador::getId))
                .findFirst()
                .get()
                .getId();
    }

    public List<Long> buscarJogadoresOrdenadoHabilidade(Integer quantidadeLista) {
        return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getSalario).reversed().thenComparing(Jogador::getId))
                .limit(quantidadeLista)
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }

    public Long buscarMelhorJogador() {
        return jogadores.stream()
                .sorted(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
                .findFirst()
                .get()
                .getId();
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
        Time other = (Time) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}