
package Controller;

import Model.Exercicio;
import Service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

    @Secured("ROLE_USER")
    @GetMapping
    public List<Exercicio> getAllExercicios() {
        return exercicioService.getAllExercicios();
    }

    @Secured("ROLE_USER")
    @GetMapping("/{id}")
    public Exercicio getExercicioById(@PathVariable Long id) {
        return exercicioService.getExercicioById(id);
    }

    @Secured("ROLE_USER")
    @PostMapping
    public Exercicio createExercicio(@RequestBody Exercicio exercicio) {
        return exercicioService.createExercicio(exercicio);
    }

    @Secured("ROLE_USER")
    @PutMapping("/{id}")
    public Exercicio updateExercicio(@PathVariable Long id, @RequestBody Exercicio exercicio) {
        return exercicioService.updateExercicio(id, exercicio);
    }
    @Secured("ROLE_USER")
    @DeleteMapping("/{id}")
    public void deleteExercicio(@PathVariable Long id) {
        exercicioService.deleteExercicio(id);
    }
}
