package Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_Exercicios")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String diaDaSemana;

    public Exercicio(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Exercicio() {

    }
}
