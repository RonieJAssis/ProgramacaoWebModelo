/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ronie
 */
public class TestePersistirNota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaModelPU");
        EntityManager em = emf.createEntityManager();
        Nota n1 = new Nota();
        //Nota n2 = em.find(Nota.class,2);
        //Nota n3 = em.find(Nota.class,3);
        //List<Nota>n4=em.createQuery("from Nota").getResultList();
        //for(Nota n:n4){
        //    System.out.println(n.getMedia());
        //}
        n1.setNota1(9.0);
        n1.setNota2(7.5);
        n1.setMedia((n1.getNota1()+n1.getNota2())/2);
        n1.setAluno(em.find(Aluno.class,1));
        n1.setDisciplina(em.find(Disciplina.class,2));
        //n2.setNota1(8.0);
        //n2.setNota2(6.5);
        //n2.setMedia((n2.getNota1()+n2.getNota2())/2);
        em.getTransaction().begin();
        em.persist(n1);
        //em.merge(n2);
        //em.remove(n3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
