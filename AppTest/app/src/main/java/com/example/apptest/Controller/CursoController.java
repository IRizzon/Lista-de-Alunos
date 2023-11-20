package com.example.apptest.Controller;

import com.example.apptest.Model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    public List listaCurso;

    public List getListaCurso(){

        listaCurso = new ArrayList<Curso>();

        listaCurso.add(new Curso("Selecione um curso"));
        listaCurso.add(new Curso("Java"));
        listaCurso.add(new Curso("Kotlin"));
        listaCurso.add(new Curso("React Native"));

        return listaCurso;

    }

    public ArrayList<String> dataSpinner(){

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < getListaCurso().size(); i++) {

            Curso objeto = (Curso) getListaCurso().get(i);

            data.add(objeto.getCursoDesejado());


        }

        return data;
    }
}
