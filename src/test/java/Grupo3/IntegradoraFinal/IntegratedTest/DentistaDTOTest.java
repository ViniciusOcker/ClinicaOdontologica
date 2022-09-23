package Grupo3.IntegradoraFinal.IntegratedTest;


import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static Grupo3.IntegradoraFinal.utils.DentistaDTOUtils.asJsonString;
import static Grupo3.IntegradoraFinal.utils.DentistaDTOUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;


@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class DentistaDTOTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity()).build();
    }

    @Test
    @WithMockUser(username = "batata", password = "batata", roles = "ADMIN")
    public void saveDentist() throws Exception{
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Walter");
        dentistaDTO.setSobrenome("White");
        dentistaDTO.setCro("2345465787/RJ");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        assertNotNull(dentistaDTO.getIdDentista());
    }
    @Test
    @WithMockUser(username = "batata", password = "batata", roles = "ADMIN")
    public void getById() throws Exception {
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Jesse");
        dentistaDTO.setSobrenome("Pinkman");
        dentistaDTO.setCro("2345215187/RJ");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/dentista/{id}", dentistaDTO.getIdDentista())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        DentistaDTO dentistaDTO1 = objectFromString(DentistaDTO.class, responseBody);

        assertEquals(dentistaDTO.getIdDentista(), dentistaDTO1.getIdDentista());
        assertEquals(dentistaDTO.getNome(), dentistaDTO1.getNome());
    }
}
