package academia.services;

import academia.models.Aluno;
import academia.models.Plano;
import java.util.HashMap;
import java.util.Map;

public class AlunoService {
    private Map<String, Aluno> bancoAlunos = new HashMap<>();

    public void cadastrarAluno(String matricula, String nome, Plano plano) {
        Aluno novoAluno = new Aluno(matricula, nome, plano);
        bancoAlunos.put(matricula, novoAluno);
        System.out.println("Aluno cadastrado com sucesso: " + nome + " (" + plano.getNome() + ")");
    }

    public Aluno buscarPorMatricula(String matricula) {
        return bancoAlunos.get(matricula);
    }
}