package com.example.apptest.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.apptest.Model.Pessoa;
import com.example.apptest.View.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    public static final String New_preferences = "pref_lista";
    SharedPreferences.Editor listaAlunos;

    public PessoaController(MainActivity mainActivity) {

        preferences = mainActivity.getSharedPreferences(New_preferences, 0);
        listaAlunos = preferences.edit();
    }


    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller","Controller_Iniciado");
        return super.toString();


    }

    public void Buscar(Pessoa pessoa){

        pessoa.setNome(preferences.getString("Nome: ", "NA"));
        pessoa.setSobrenome(preferences.getString("Sobrenome: ", "NA"));
        pessoa.setMatricula(preferences.getString("Matrícula: ", "NA"));
        pessoa.setCPF(preferences.getString("CPF: ", "NA"));

    }


    public void Salvar(Pessoa pessoa) {

        listaAlunos.putString("Nome: ", pessoa.getNome());
        listaAlunos.putString("Sobrenome: ", pessoa.getSobrenome());
        listaAlunos.putString("Matrícula: ", pessoa.getMatricula());
        listaAlunos.putString("CPF: ", pessoa.getCPF());
        listaAlunos.apply();

        Log.d("MVC_Controller", "Dados Salvos" + toString());
    }

    public void Limpar(Pessoa pessoa){

        listaAlunos.clear();
        listaAlunos.apply();

    }
}
