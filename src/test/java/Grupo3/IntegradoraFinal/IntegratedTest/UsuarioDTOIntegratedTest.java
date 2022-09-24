package Grupo3.IntegradoraFinal.IntegratedTest;

import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static Grupo3.IntegradoraFinal.utils.DentistaDTOUtils.asJsonString;
import static Grupo3.IntegradoraFinal.utils.DentistaDTOUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UsuarioDTOIntegratedTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "anakin", password = "batata789", roles = "ADMIN")
    public void saveUser() throws Exception{
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNomeDeUsuario("Vader");
        usuarioDTO.setSenha("batata789");
        usuarioDTO.setAdmin(true);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/usuario/create")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(usuarioDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        usuarioDTO = objectFromString(UsuarioDTO.class, responseBody);

        assertNotNull(usuarioDTO.getIdUsuario());
    }

    @Test
    @WithMockUser(username = "batata", password = "batata789", roles = "ADMIN")
    public void getById() throws Exception{
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNomeDeUsuario("Anakin");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/usuario/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(usuarioDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isCreated())
                        .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        usuarioDTO = objectFromString(UsuarioDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/usuario/{id}", usuarioDTO.getIdUsuario())
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        UsuarioDTO usuarioDTO1 = objectFromString(UsuarioDTO.class, responseBody);

        assertEquals(usuarioDTO.getIdUsuario(), usuarioDTO1.getIdUsuario());
        assertEquals(usuarioDTO.getNomeDeUsuario(), usuarioDTO1.getNomeDeUsuario());
    }

}
