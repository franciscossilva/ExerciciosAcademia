

package Service;
import Model.Exercicio;
import Repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ExercicioServiceImpl implements ExercicioService {

    private final ExercicioRepository exercicioRepository;

    @Autowired
    public ExercicioServiceImpl(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    @Override
    public List<Exercicio> getAllExercicios() {
        return exercicioRepository.findAll();
    }

    @Override
    public Exercicio getExercicioById(Long id) {
        return exercicioRepository.findById(id).orElse(null);
    }

    @Override
    public Exercicio createExercicio(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    @Override
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

    @Override
    public void deleteExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}
