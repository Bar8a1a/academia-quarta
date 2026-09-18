package com.academia.service;

import com.academia.exception.EntidadeNaoEncontradaException;
import com.academia.exception.RegraNegocioException;
import com.academia.model.Aluno;
import com.academia.model.Exercicio;
import com.academia.model.Instrutor;
import com.academia.model.Treino;
import com.academia.repository.AlunoRepository;
import com.academia.repository.InstrutorRepository;
import com.academia.repository.TreinoRepository;

import java.util.List;

public class TreinoService {
    private final TreinoRepository treinoRepository;
    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;

    // Injeção de Dependência via construtor
    public TreinoService(TreinoRepository treinoRepository,
                         AlunoRepository alunoRepository,
                         InstrutorRepository instrutorRepository) {
        this.treinoRepository = treinoRepository;
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
    }

    public Treino criarTreino(Long alunoId, Long instrutorId, String nomeTreino, String objetivo) {
        Aluno aluno = alunoRepository.buscarPorId(alunoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Aluno não encontrado com ID: " + alunoId));

        if (!aluno.isMatriculaAtiva()) {
            throw new RegraNegocioException("Não é possível prescrever treino para aluno com matrícula inativa: " + aluno.getNome());
        }

        Instrutor instrutor = instrutorRepository.buscarPorId(instrutorId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Instrutor não encontrado com ID: " + instrutorId));

        Treino treino = new Treino(null, nomeTreino, objetivo, aluno, instrutor);
        return treinoRepository.salvar(treino);
    }

    public Treino adicionarExercicio(Long treinoId, String nomeExercicio, String grupoMuscular, int series, int repeticoes, int descansoSegundos) {
        Treino treino = treinoRepository.buscarPorId(treinoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Treino não encontrado com ID: " + treinoId));

        Exercicio exercicio = new Exercicio(System.currentTimeMillis(), nomeExercicio, grupoMuscular, series, repeticoes, descansoSegundos);
        treino.adicionarExercicio(exercicio);

        return treinoRepository.salvar(treino);
    }

    public List<Treino> listarPorAluno(Long alunoId) {
        return treinoRepository.buscarPorAlunoId(alunoId);
    }

    public List<Treino> listarTodos() {
        return treinoRepository.buscarTodos();
    }
}