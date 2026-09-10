package academia.services;

import academia.interfaces.NotificadorAcesso;
import academia.models.Aluno;

public class CatracaService {
    // Depende da abstração, não da classe concreta (DIP)
    private final NotificadorAcesso notificador;

    public CatracaService(NotificadorAcesso notificador) {
        this.notificador = notificador;
    }

    public boolean validarEntrada(Aluno aluno, int horaAtual) {
        if (aluno == null) {
            System.out.println("Acesso Negado: Aluno não localizado.");
            return false;
        }

        // Chamada polimórfica (LSP): funciona tanto para Plano comum quanto PlanoOffPeak
        if (aluno.getPlano().permiteAcessoNoHorario(horaAtual)) {
            System.out.println("Catraca liberada para: " + aluno.getNome());
            notificador.notificarEntrada(aluno.getNome(), "Entrada registrada com sucesso às " + horaAtual + "h.");
            return true;
        } else {
            System.out.println("Acesso Negado para " + aluno.getNome() + ": Horário fora do permitido pelo plano.");
            return false;
        }
    }
}