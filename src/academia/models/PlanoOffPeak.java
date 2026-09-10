package academia.models;

// Subclasse que especializa o comportamento sem quebrar o contrato da classe pai
public class PlanoOffPeak extends Plano {

    public PlanoOffPeak(double valorBase) {
        super("Plano Horário Alternativo (Off-Peak)", valorBase);
    }

    @Override
    public boolean permiteAcessoNoHorario(int horaAtual) {
        // Restrito a horários fora de pico (ex: 10h às 16h)
        return horaAtual >= 10 && horaAtual <= 16;
    }
}