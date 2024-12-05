// package com.shadowcard.demo;

// import com.shadowcard.demo.dtos.req.CreateAddDeckUsuario;
// import com.shadowcard.demo.entities.DeckEntity;
// import com.shadowcard.demo.entities.UserEntity;
// import com.shadowcard.demo.repositories.DeckRepository;
// import com.shadowcard.demo.repositories.UserRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import com.shadowcard.demo.services.UsuarioService;


// import java.util.Arrays;
// import java.util.List;

// import static org.mockito.Mockito.*;

// import static org.junit.jupiter.api.Assertions.*;

// public class AddDeckTest {

//     @Mock
//     private UserRepository userRepository;

//     @Mock
//     private DeckRepository deckRepository;

//     @InjectMocks
//     private UsuarioService usuarioService;

//     private UserEntity usuario;
//     private DeckEntity deck1;
//     private DeckEntity deck2;

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.openMocks(this);

//         // Criar um usuário fictício
//         usuario = new UserEntity();
//         usuario.setId(1);
//         usuario.setFullName("Ultron");
//         usuario.setEmail("ultron@example.com");

//         // Criar dois decks fictícios
//         deck1 = new DeckEntity();
//         deck1.setId(1);
//         deck1.setTipo("Ataque");

//         deck2 = new DeckEntity();
//         deck2.setId(2);
//         deck2.setTipo("Defesa");
//     }

//     @Test
//     public void testAddDecksToUsuario() {
//         CreateAddDeckUsuario dto = new CreateAddDeckUsuario();
//         dto.setUsuarioId(usuario.getId());
//         dto.setDeckIds(Arrays.asList(deck1.getId(), deck2.getId()));

//         // Mocking the repository methods
//         when(userRepository.findById(usuario.getId())).thenReturn(java.util.Optional.of(usuario));
//         when(deckRepository.findAllById(dto.getDeckIds())).thenReturn(Arrays.asList(deck1, deck2));

//         // Chama o serviço para adicionar os decks ao usuário
//         usuarioService.addDecksToUsuario(dto);

//         // Verifica se os decks foram adicionados ao usuário
//         assertTrue(usuario.getDecks().contains(deck1));
//         assertTrue(usuario.getDecks().contains(deck2));

//         // Verifica se o método save foi chamado
//         verify(userRepository, times(1)).save(usuario);
//     }
// }
