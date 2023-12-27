package Service;

import Model.Exercicio;
import Repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private ExercicioRepository exercicioRepository;

    @Autowired
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public List<Exercicio> getAllExercicios() {
        return exercicioRepository.findAll();
    }

    public Exercicio getExercicioById(Long id) {
        return exercicioRepository.findById(id).orElse(null);
    }

    public Exercicio createExercicio(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public Exercicio updateExercicio(Long id, Exercicio updatedExercicio) {
        Exercicio exercicioExistente = exercicioRepository.findById(id).orElse(null);

        if (exercicioExistente != null) {
            exercicioExistente.setNome(updatedExercicio.getNome());
            exercicioExistente.setDescricao(updatedExercicio.getDescricao());
            exercicioExistente.setDiaDaSemana(updatedExercicio.getDiaDaSemana());

            return exercicioRepository.save(exercicioExistente);
        }

        return null;
    }

    public void deleteExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}
