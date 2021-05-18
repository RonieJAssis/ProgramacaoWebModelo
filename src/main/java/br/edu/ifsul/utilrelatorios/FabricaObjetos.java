/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Nota;
import br.edu.ifsul.modelo.Professor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author ronie
 */
public class FabricaObjetos {

    public static List<Disciplina> carregaDisciplina() {
        List<Disciplina> lista = new ArrayList<>();
        Disciplina d = new Disciplina();
        d.setId(1);
        d.setNome("teste");
        d.setCargaHoraria(1.1);
        d.setConhecimentosMinimos("<h1>teste teste teste teste teste teste teste<h1><h1>teste teste teste teste teste teste teste<h1><h1>teste teste teste teste teste teste teste<h1>");
        d.setDescricao("<h1>teste teste teste teste teste teste teste<h1><h1>teste teste teste teste teste teste teste<h1><h1>teste teste teste teste teste teste teste<h1>");
        Curso c = new Curso();
        c.setNome("teste");
        d.setCurso(c);
        Aluno a = new Aluno();
        a.setEmail("a@a");
        a.setNome("testeAluno");
        a.setId(1);
        Nota n = new Nota();
        n.setAluno(a);
        n.setDisciplina(d);
        n.setNota1(1.0);
        n.setNota2(1.0);
        n.setMedia(1.0);
        d.addNotas(n);
        lista.add(d);
        return lista;
    }

    public static List<Especialidade> carregaEspecialidade() {
        List<Especialidade> lista = new ArrayList<>();
        Especialidade e = new Especialidade();
        e.setId(1);
        e.setNome("teste");
        lista.add(e);
        return lista;
    }

    public static List<Aluno> carregaAluno() {
        List<Aluno> lista = new ArrayList<>();
        Aluno a = new Aluno();
        a.setEmail("a@a");
        a.setNome("testeAluno");
        a.setId(1);
        a.setNascimento(new GregorianCalendar(2000, Calendar.FEBRUARY, 02));
        lista.add(a);
        return lista;
    }

    public static List<Professor> carregaProfessor() {
        List<Professor> lista = new ArrayList<>();
        Professor p = new Professor();
        p.setEmail("a@a");
        p.setNome("testeAluno");
        p.setId(1);
        p.setNascimento(new GregorianCalendar(2000, Calendar.FEBRUARY, 02));
        p.setTitulacao("testeTit");
        p.setTopicosInteresse("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Especialidade e = new Especialidade();
        e.setId(1);
        e.setNome("teste");
        p.setEspecialidade(e);
        lista.add(p);
        return lista;
    }

    public static List<Curso> carregaCurso() {
        List<Curso> lista = new ArrayList<>();
        Curso c = new Curso();
        c.setNome("testeCurso");
        c.setId(1);
        c.setAtivo(true);
        c.setSigla("AA");
        c.setInicioAtividades(new GregorianCalendar(2000, Calendar.FEBRUARY, 02));
        Instituicao i = new Instituicao();
        i.setAnoFundacao(new GregorianCalendar(2000, Calendar.FEBRUARY, 02));
        i.setNome("testeI");
        c.setDescricao("<h1>teste teste teste teste teste teste teste<h1><h1>teste teste teste teste teste teste teste<h1><h1>teste teste teste teste teste teste teste<h1>");
        c.setInstituicao(i);
        Disciplina d = new Disciplina();
        d.setId(1);
        d.setNome("teste");
        ArrayList<Disciplina> ld = new ArrayList<Disciplina>();
        ld.add(d);
        d.setId(2);
        d.setNome("teste2");
        ld.add(d);
        c.setDisciplinas(ld);
        lista.add(c);
        return lista;
    }

    public static List<Instituicao> carregaInstituicoes() {
        List<Instituicao> lista = new ArrayList<>();
        Instituicao i = new Instituicao();
        i.setAnoFundacao(new GregorianCalendar(2000, Calendar.FEBRUARY, 02));
        i.setNome("testeI");
        lista.add(i);
        return lista;
    }
}
