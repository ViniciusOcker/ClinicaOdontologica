package Grupo3.IntegradoraFinal.DTOTest;

import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacienteDTOTest {
    @SpringBootTest
    @ExtendWith(SpringExtension.class)
    @WebAppConfiguration
    public static class PacienteDTest {

        @Autowired
        private PacienteDTO pacienteDTO;

        @Test
        public void PacienteTest(){
            PacienteDTO pacienteDTO1 = new PacienteDTO();
            pacienteDTO1.setNome("Cleber");
            pacienteDTO1.setSobrenome("Silva");
            pacienteDTO1.setRg("552211332");

            assertEquals("Cleber", pacienteDTO1.getNome());
            assertEquals("Silva", pacienteDTO1.getSobrenome());
            assertEquals("552211332", pacienteDTO1.getRg());
        }

    }
}
