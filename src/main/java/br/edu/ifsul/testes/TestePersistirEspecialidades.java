/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ronie
 */
public class TestePersistirEspecialidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaModelPU");
        EntityManager em = emf.createEntityManager();
        Especialidade e1 = new Especialidade();
        //Especialidade e2 = em.find(Especialidade.class,2);
        //Especialidade e3 = em.find(Especialidade.class,3);
        //List<Especialidade>e4=em.createQuery("from Especialidade").getResultList();
        //for(Especialidade e:e4){
        //    System.out.println(e.getNome());
        //}
        e1.setNome("teste1");
        //e2.setNome("teste2");
        em.getTransaction().begin();
        em.persist(e1);
        //em.merge(e2);
        //em.remove(e3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
