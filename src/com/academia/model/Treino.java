package com.academia.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Treino {

    private String id;
    private String nome;
    private String objetivo;
    private Aluno aluno;
    private Instrutor instrutor;
    private List <Exercicio> exercicios;
    private LocalDate dataCriacao;


    public Treino(String id, String nome, String objetivo, Aluno aluno, Instrutor instrutor, List <Exercicio> exercicios){
        this.id = id;
        this.nome = nome;
        this.objetivo = objetivo;
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.exercicios = exercicios;
        this.dataCriacao = LocalDate.now();
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getObjetivo(){
        return objetivo;
    }
    public void setObjetivo(String objetivo){
        this.objetivo = objetivo;
    }
    public Aluno getAluno(){
        return aluno;
    }
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
    public Instrutor getInstrutor(){
        return instrutor;
    }
    public void setInstrutor(Instrutor instrutor){
        this.instrutor = instrutor;
    }
    public List<Exercicio> getExercicios(){
        return exercicios;
    }
    public void setExercicios(List<Exercicio> exercicios){
        this.exercicios = exercicios;
    }
    public LocalDate getDataCriacao(){
        return dataCriacao;
    }
    public void setDataCriacao(LocalDate dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Treino{id='" + id + "'\n" +
                "nome='" + nome + "'\n" +
                "objetivo='" + objetivo + "'\n" +
                "aluno=" + aluno.getId() + "\n" +
                "instrutor=" + instrutor.getId() + "\n" +
                "exercicios=" + exercicios + "\n" +
                "dataCriacao=" + dataCriacao + "\n" +
                "}";
    }
    
}