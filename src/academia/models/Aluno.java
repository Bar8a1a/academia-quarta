package academia.models;

public class Aluno {
    private String matricula;
    private String nome;
    private Plano plano;

    public Aluno(String matricula, String nome, Plano plano) {
        this.matricula = matricula;
        this.nome = nome;
        this.plano = plano;
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public Plano getPlano() { return plano; }
}