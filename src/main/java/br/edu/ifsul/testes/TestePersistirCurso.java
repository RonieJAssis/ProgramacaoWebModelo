/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;
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
public class TestePersistirCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaModelPU");
        EntityManager em = emf.createEntityManager();
        Curso c1 = new Curso();
        //Curso c2 = em.find(Curso.class,2);
        //Curso c3 = em.find(Curso.class,3);
        List<Curso>c4=em.createQuery("from Curso").getResultList();
        for(Curso c:c4){
            System.out.println(c.getNome());
        }
        c1.setNome("teste1");
        c1.setAtivo(Boolean.TRUE);
        c1.setDescricao("aaaaaaaaaaaaaaa");
        c1.setInicioAtividades(new GregorianCalendar(2002, Calendar.FEBRUARY, 02));
        c1.setInstituicao(em.find(Instituicao.class,1));
        c1.setSigla("AA");
        //c2.setNome("teste2");
        em.getTransaction().begin();
        em.persist(c1);
        //em.merge(c2);
        //em.remove(c3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
