/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ronie
 */
public class TestePersistirDisciplina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaModelPU");
        EntityManager em = emf.createEntityManager();
        Disciplina d1 = new Disciplina();
        //Disciplina d2 = em.find(Disciplina.class,2);
        //Disciplina d3 = em.find(Disciplina.class,3);
        List<Disciplina>d4=em.createQuery("from Disciplina").getResultList();
        for(Disciplina d:d4){
            System.out.println(d.getNome());
        }
        d1.setCargaHoraria(1200.0);
        d1.setConhecimentosMinimos("aaaaaaaaaaaaaa");
        d1.setDescricao("aaaaaaaaaaaaaaaaaaaaaa");
        d1.setNome("teste1");
        d1.setCurso(em.find(Curso.class,1));
        
        
        //d2.setNome("teste2");
        em.getTransaction().begin();
        em.persist(d1);
        //em.merge(d2);
        //em.remove(d3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
