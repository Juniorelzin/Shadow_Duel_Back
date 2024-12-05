package com.shadowcard.demo;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.shadowcard.demo.dtos.res.ShowUsuarioDTO;
import com.shadowcard.demo.entities.UserEntity;
import com.shadowcard.demo.repositories.UserRepository;
import com.shadowcard.demo.services.UsuarioService;

public class PegarUsuarioTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private UserEntity userEntity1;
    private UserEntity userEntity2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        userEntity1 = new UserEntity();
        userEntity1.setId(1);
        userEntity1.setFullName("Ultron");
        userEntity1.setEmail("ultron@example.com");

        userEntity2 = new UserEntity();
        userEntity2.setId(2);
        userEntity2.setFullName("Ultron");
        userEntity2.setEmail("ultron@example.com");
    }

    @Test
    public void testGetUsuarios() {
   
        when(userRepository.findAll()).thenReturn(Arrays.asList(userEntity1, userEntity2));

        List<ShowUsuarioDTO> usuarios = usuarioService.getUsuarios();

   
        assertEquals(2, usuarios.size());
        assertEquals("Ultron", usuarios.get(0).getFullName());
        assertEquals("Ultron2", usuarios.get(1).getFullName());
    }
}
