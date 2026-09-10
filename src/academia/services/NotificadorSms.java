package academia.services;

import academia.interfaces.NotificadorAcesso;

public class NotificadorSms implements NotificadorAcesso {
    @Override
    public void notificarEntrada(String nomeAluno, String mensagem) {
        System.out.println("[SMS enviado para " + nomeAluno + "]: " + mensagem);
    }
}