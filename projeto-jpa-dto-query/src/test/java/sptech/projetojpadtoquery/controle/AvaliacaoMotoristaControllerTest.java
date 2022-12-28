package sptech.projetojpadtoquery.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.projetojpadtoquery.repositorio.AvaliacaoMotoristaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
@SpringBootTest
class AvaliacaoMotoristaControllerTest {

    @Autowired
    private AvaliacaoMotoristaController controller;

    @MockBean
    private AvaliacaoMotoristaRepository repository;

    @Test
    @DisplayName("Verifica média avaliação presente")
    void mediaAvaliacaoExiste(){
        when(repository.getMediaAvaliacoes(anyInt()))
                .thenReturn(Optional.of(25.0));

        ResponseEntity<Double> mediaAvaliacoes =
                controller.getMediaAvaliacoes(1);

        assertEquals(200, mediaAvaliacoes.getStatusCodeValue());
        assertNotNull(mediaAvaliacoes.getBody());

    }

    @Test
    @DisplayName("Verifica média avaliação não presente")
    void mediaAvaliacaoNaoExiste(){
        when(repository.getMediaAvaliacoes(anyInt()))
                .thenReturn(Optional.empty());

        ResponseEntity<Double> mediaAvaliacoes =
                controller.getMediaAvaliacoes(1);

        assertEquals(404, mediaAvaliacoes.getStatusCodeValue());
        assertNull(mediaAvaliacoes.getBody());

    }
}