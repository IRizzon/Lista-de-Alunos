package com.example.apptest.Model;

public class Pessoa {

    private String Nome;
    private String Sobrenome;
    private String Matricula;
    private String CPF;


    public Pessoa(){}

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.Sobrenome = sobrenome;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        this.Matricula = matricula;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome='" + Nome + '\'' +
                ", Sobrenome='" + Sobrenome + '\'' +
                ", Matricula='" + Matricula + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
