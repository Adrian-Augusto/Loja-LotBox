package Valorya.box.Controller;

import Valorya.box.DTO.UserCreateDTO;
import Valorya.box.DTO.UserResponseDTO;
import Valorya.box.Entity.User;
import Valorya.box.Mapper.UserMapper;
import Valorya.box.Repository.UserRepository;
import Valorya.box.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // <- importa tudo de uma vez
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> salvarUsuario(@RequestBody @Valid UserCreateDTO dto) {
        UserResponseDTO user = userService.salvarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listarUsuarios() {
        List<UserResponseDTO> usuarios = userService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
