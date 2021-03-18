/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Instituicao;
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
public class TestePersistirInstituicao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaModelPU");
        EntityManager em = emf.createEntityManager();
        //Instituicao i1 = new Instituicao();
        Instituicao i2 = em.find(Instituicao.class,2);
        Instituicao i3 = em.find(Instituicao.class,3);
        List<Instituicao>i4=em.createQuery("from Instituicao").getResultList();
        i4.forEach(i -> {
            System.out.println(i.getNome());
        });
        //i1.setNome("teste1");
        //i1.setAnoFundacao(new GregorianCalendar(2000, Calendar.JANUARY, 01));
        //i2.setNome("teste2");
        i2.setAnoFundacao(new GregorianCalendar(2002, Calendar.FEBRUARY, 02));
        em.getTransaction().begin();
        //em.persist(i1);
        em.merge(i2);
        em.remove(i3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
