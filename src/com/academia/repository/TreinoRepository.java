package com.academia.repository;
import com.academia.model.Treino;
import java.util.List;

public interface TreinoRepository extends Repository<Treino, String> {
    List<Treino> buscarPorAlunoId(Long alunoId);
    List<Treino> buscarPorInstrutorId(Long instrutorId);
}