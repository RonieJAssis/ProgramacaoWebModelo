/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronie
 */
public class FabricaDisciplinas {
    public static List<Disciplina> carregaDisciplina(){
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
        lista.add(d);
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
        return lista;
    }
}
