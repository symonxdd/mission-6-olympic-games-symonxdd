package be.pxl.paj.olympicgames.api;

import be.pxl.paj.olympicgames.api.data.RaceDTO;
import be.pxl.paj.olympicgames.service.OlympicGamesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static be.pxl.paj.olympicgames.builder.RaceDTOBuilder.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OlympicGamesController.class)
public class OlympicGamesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OlympicGamesService olympicGamesService;

    @Test
    void createRaceSuccess() throws Exception {
        mockMvc.perform(post("/olympicgames/races")
                        .content("{\n" +
                                "    \"dateTime\": \"2021-09-09 13:15:00\",\n" +
                                "    \"discipline\": \"SPRINT_100M\"\n" +
                                "}")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createRaceThrowsExceptionWhenNoDiscipline() throws Exception {
        mockMvc.perform(post("/olympicgames/races")
                        .content("{\n" +
                                "    \"dateTime\": \"2021-09-09 13:15:00\",\n" +
                                "    \"discipline\": \"\"\n" +
                                "}")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void getRacesReturnsExistingRaces() throws Exception {
        RaceDTO raceDTO = aRaceDTO().build();
        when(olympicGamesService.getRaces()).thenReturn(List.of(raceDTO));
        mockMvc.perform(get("/olympicgames/races")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(ID))
                .andExpect(jsonPath("$[0].discipline").value(DISCIPLINE.name()));
    }
}
