package academia;

import academia.interfaces.NotificadorAcesso;
import academia.models.Aluno;
import academia.models.Plano;
import academia.models.PlanoOffPeak;
import academia.services.AlunoService;
import academia.services.CatracaService;
import academia.services.NotificadorEmail;

public class Main {
    public static void main(String[] args) {
        // 1. Serviços de domínio
        AlunoService alunoService = new AlunoService();

        // 2. Planos (LSP)
        Plano planoGeral = new Plano("Plano Total", 129.90);
        Plano planoOffPeak = new PlanoOffPeak(79.90);

        // 3. Cadastro (SRP)
        alunoService.cadastrarAluno("A001", "Lucas Pereira", planoGeral);
        alunoService.cadastrarAluno("A002", "Mariana Costa", planoOffPeak);

        System.out.println("\n--- SIMULANDO ACESSO ÀS 18h (HORÁRIO DE PICO) ---");

        // 4. Injeção de dependência (DIP & OCP)
        NotificadorAcesso notificador = new NotificadorEmail();
        CatracaService catraca = new CatracaService(notificador);

        Aluno aluno1 = alunoService.buscarPorMatricula("A001");
        Aluno aluno2 = alunoService.buscarPorMatricula("A002");

        // Aluno 1 tem plano integral: deve passar
        catraca.validarEntrada(aluno1, 18);

        System.out.println();

        // Aluno 2 tem plano off-peak: deve ser barrado às 18h
        catraca.validarEntrada(aluno2, 18);
    }
}