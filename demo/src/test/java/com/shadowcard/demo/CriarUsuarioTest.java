package com.shadowcard.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.shadowcard.demo.dtos.req.CreateUsuarioDTO;
import com.shadowcard.demo.entities.UserEntity;
import com.shadowcard.demo.repositories.UserRepository;
import com.shadowcard.demo.services.UsuarioService;

public class CriarUsuarioTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private CreateUsuarioDTO createUsuarioDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setFullName("Ultron");
        createUsuarioDTO.setEmail("ultron@example.com");
        createUsuarioDTO.setPassword("ultron123");
    }

    @Test
    public void testCreateUsuario() {
   
        UserEntity userEntityMock = new UserEntity();
        userEntityMock.setFullName(createUsuarioDTO.getFullName());
        userEntityMock.setEmail(createUsuarioDTO.getEmail());
        userEntityMock.setPassword(createUsuarioDTO.getPassword());

        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntityMock);


        usuarioService.createUsuario(createUsuarioDTO);

      
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }
}
