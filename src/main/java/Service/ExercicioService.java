

package Service;

import Model.Exercicio;



import java.util.List;

public interface ExercicioService {
    List<Exercicio> getAllExercicios();
    Exercicio getExercicioById(Long id);
    Exercicio createExercicio(Exercicio exercise);
    Exercicio updateExercicio(Long id, Exercicio exercise);
    void deleteExercicio(Long id);
}
