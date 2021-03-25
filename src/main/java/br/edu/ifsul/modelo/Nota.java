/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ronie
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable{
    @Id
    @SequenceGenerator(name="seq_nota",sequenceName = "seq_nota_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_nota",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "a nota 1 deve ser informada")
    @Column(name = "nota1", nullable = false, columnDefinition = "numeric(4,2)")
    private Double nota1;
    @NotNull(message = "a nota 2 deve ser informada")
    @Column(name = "nota2", nullable = false, columnDefinition = "numeric(4,2)")
    private Double nota2;
    @NotNull(message = "a media deve ser informada")
    @Column(name = "media", nullable = false, columnDefinition = "numeric(4,2)")
    private Double media;
    @NotNull(message = "O aluno deve ser informado")
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    private Aluno aluno;
    @NotNull(message = "A disciplina deve ser informada")
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false)
    Disciplina disciplina;
    
    public Nota(){
        
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
     * @return the nota1
     */
    public Double getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    /**
     * @return the nota2
     */
    public Double getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    /**
     * @return the media
     */
    public Double getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

        /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
     
}
