/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
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
public class TestePersistirProfessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaModelPU");
        EntityManager em = emf.createEntityManager();
        Professor p1 = new Professor();
        //Professor p2 = em.find(Professor.class,2);
        //Professor p3 = em.find(Professor.class,3);
        List<Professor>p4=em.createQuery("from Professor").getResultList();
        for(Professor p:p4){
            System.out.println(p.getNome());
        }
        p1.setNome("teste1");
        p1.setEmail("teste@teste");
        p1.setEspecialidade(em.find(Especialidade.class,1));
        p1.setNascimento(new GregorianCalendar(1975, Calendar.FEBRUARY, 02));
        p1.setTitulacao("Doutor");
        p1.setTopicosInteresse("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //p2.setNome("teste2");
        em.getTransaction().begin();
        em.persist(p1);
        //em.merge(p2);
        //em.remove(p3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
