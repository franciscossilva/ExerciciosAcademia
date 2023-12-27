
package Controller;

import Model.Exercicio;
import Service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private  ExercicioService exercicioService;

    @Autowired
    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @GetMapping
    public List<Exercicio> getAllExercicios() {
        return exercicioService.getAllExercicios();
    }

    @GetMapping("/{id}")
    public Exercicio getExercicioById(@PathVariable Long id) {
        return exercicioService.getExercicioById(id);
    }

    @PostMapping
    public Exercicio createExercicio(@RequestBody Exercicio exercicio) {
        return exercicioService.createExercicio(exercicio);
    }

    @PutMapping("/{id}")
    public Exercicio updateExercicio(@PathVariable Long id, @RequestBody Exercicio exercicio) {
        return exercicioService.updateExercicio(id, exercicio);
    }

    @DeleteMapping("/{id}")
    public void deleteExercicio(@PathVariable Long id) {
        exercicioService.deleteExercicio(id);
    }
}
