package bo.edu.ucb.ingsoft.botuni;
import bo.edu.ucb.ingsoft.botuni.DAO.EstudianteDao;
import bo.edu.ucb.ingsoft.botuni.DTO.EstudianteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisTest {

    private EstudianteDao estudianteDao;

    @Autowired
    public MyBatisTest(EstudianteDao estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    @Test
    public void testSelectAllEstudiantes() {
        List<EstudianteDto> employeeDtoList = estudianteDao.findAllEstudiante();
        for( EstudianteDto emp : employeeDtoList) {
            System.out.println("Estudiante: " + emp);
        }

    }
}