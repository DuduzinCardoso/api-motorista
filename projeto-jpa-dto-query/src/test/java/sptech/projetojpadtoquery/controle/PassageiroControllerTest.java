package sptech.projetojpadtoquery.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.resposta.PassageiroSimplesResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PassageiroControllerTest {
    @Autowired
    private PassageiroController controller;

    @MockBean
    private PassageiroRepository repository;

    @Test
    @DisplayName("Lista vazia e 204")
    void getSimplesVazia(){
        when(repository.getPassageirosSimples()).thenReturn(new ArrayList<>());

        ResponseEntity<List<PassageiroSimplesResponse>> simples =
                controller.getSimples();

        assertEquals(204, simples.getStatusCodeValue());
        assertNull(simples.getBody());
    }

    @Test
    @DisplayName("Lista de passageiros e 200")
    void getSimples(){
        when(repository.getPassageirosSimples()).thenReturn(List.of(
                new PassageiroSimplesResponse(1, null),
                new PassageiroSimplesResponse(2, null)
                ));

        ResponseEntity<List<PassageiroSimplesResponse>> simples =
                controller.getSimples();

        assertEquals(200, simples.getStatusCodeValue());
        assertTrue(simples.getBody().size() > 0);
    }
}