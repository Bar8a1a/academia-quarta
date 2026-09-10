package academia.models;

public class Plano {
    private String nome;
    private double valorBase;

    public Plano(String nome, double valorBase) {
        this.nome = nome;
        this.valorBase = valorBase;
    }

    public boolean permiteAcessoNoHorario(int horaAtual) {
        // Plano padrão permite acesso em qualquer horário da academia (ex: 6h às 23h)
        return horaAtual >= 6 && horaAtual <= 23;
    }

    public double getValorBase() { return valorBase; }
    public String getNome() { return nome; }
}