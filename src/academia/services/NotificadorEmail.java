package academia.services;

import academia.interfaces.NotificadorAcesso;

public class NotificadorEmail implements NotificadorAcesso {
    @Override
    public void notificarEntrada(String nomeAluno, String mensagem) {
        System.out.println("[EMAIL enviado para " + nomeAluno + "]: " + mensagem);
    }
}