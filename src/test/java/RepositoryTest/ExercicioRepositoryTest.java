package RepositoryTest;

import Repository.ExercicioRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ExercicioRepositoryTest {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Test
    public void testSave() {

    }

    @Test
    public void testFindById() {

    }

    @Test
    public void testDeleteById() {

    }

}
