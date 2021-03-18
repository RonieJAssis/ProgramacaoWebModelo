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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author ronie
 */
@Entity
@Table(name = "professor")
public class Professor extends Aluno implements Serializable{
    @NotBlank(message = "A titulação não pode ser em branco")
    @Length(max = 50, message = "A titulação não pode ter mais que {max} caracteres")
    @Column(name = "titulacao", nullable = false, length = 50)
    private String titulacao;
    @NotBlank(message = "Os topicos de interesse não podem ser em branco")
    @Column(name = "topicos_interesse", columnDefinition = "text",nullable = false)
    private String topicosInteresse;
    @NotNull(message = "A especialidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false) 
    private Especialidade especialidade;
    
    public Professor() {
    }
    
    
    /**
     * @return the titulacao
     */
    public String getTitulacao() {
        return titulacao;
    }

    /**
     * @param titulacao the titulacao to set
     */
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    /**
     * @return the topicosInteresse
     */
    public String getTopicosInteresse() {
        return topicosInteresse;
    }

    /**
     * @param topicosInteresse the topicosInteresse to set
     */
    public void setTopicosInteresse(String topicosInteresse) {
        this.topicosInteresse = topicosInteresse;
    }
    
    /**
     * @return the especialidade
     */
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.titulacao);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        return true;
    }
     
}
