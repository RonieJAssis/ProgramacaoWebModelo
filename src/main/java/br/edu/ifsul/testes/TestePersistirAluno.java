/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
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
public class TestePersistirAluno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaModelPU");
        EntityManager em = emf.createEntityManager();
        Aluno a1 = new Aluno();
        //Aluno a2 = em.find(Aluno.class,2);
        //Professor p3 = em.find(Professor.class,3);
        List<Aluno>a4=em.createQuery("from Aluno").getResultList();
        for(Aluno a:a4){
            System.out.println(a.getNome());
        }
        a1.setNome("teste1aluno");
        a1.setEmail("testealuno@teste");
        a1.setNascimento(new GregorianCalendar(2000, Calendar.FEBRUARY, 02));
        //a2.setNome("teste2");
        em.getTransaction().begin();
        em.persist(a1);
        //em.merge(a2);
        //em.remove(a3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
