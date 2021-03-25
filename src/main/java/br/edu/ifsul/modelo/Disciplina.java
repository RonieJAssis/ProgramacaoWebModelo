/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author ronie
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplinas_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)   
    private Integer id;
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50) 
    private String nome;
    @Column(name = "descricao", columnDefinition = "text",nullable = false)
    private String descricao;
    @NotNull(message = "a carga horaria deve ser informada")
    @Column(name = "carga horaria", nullable = false, columnDefinition = "numeric(10,2)")
    private Double cargaHoraria;
    @Column(name = "conhecimento_minimos", columnDefinition = "text",nullable = false)
    private String conhecimentosMinimos;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "alunos_matriculados", 
            joinColumns = 
                    @JoinColumn(name = "disciplina", referencedColumnName = "id", 
                            nullable = false), 
            inverseJoinColumns = 
                    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false))
    private Set<Aluno> alunos=new HashSet<>();
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> notas;
    @NotNull(message = "O curso deve ser informado")
    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "id", nullable = false)
    private Curso curso;
    
    public Disciplina() {
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the cargaHoraria
     */
    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the conhecimentosMinimos
     */
    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    /**
     * @param conhecimentosMinimos the conhecimentosMinimos to set
     */
    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    /**
     * @return the alunos
     */
    public Set<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public void addAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }


    /**
     * @return the notas
     */
    public List<Nota> getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    
    public void addNotas(Nota nota) {
        nota.setDisciplina(this);
        this.notas.add(nota);
    }
    
    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
