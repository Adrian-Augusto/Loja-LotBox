package Valorya.box.Service;
import Valorya.box.Entity.User;

import Valorya.box.DTO.UserCreateDTO;
import Valorya.box.DTO.UserResponseDTO;

import Valorya.box.Mapper.UserMapper;
import Valorya.box.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Criar usuário
    public UserResponseDTO salvarUsuario(UserCreateDTO dto) {
        User user = UserMapper.toEntity(dto);                // Converte DTO → Entidade
        User salvo = userRepository.save(user);              // Salva no banco
        return UserMapper.toDTO(salvo);                      // Converte Entidade → DTO de resposta
    }

    // Listar todos os usuários
    public List<UserResponseDTO> listarUsuarios() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)                      // Converte cada entidade → DTO
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public Optional<UserResponseDTO> buscarPorId(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO);
    }

    // Deletar usuário
    public void deletarUsuario(Long id) {
        userRepository.deleteById(id);
    }

    // Buscar por e-mail
    public Optional<UserResponseDTO> buscarPorEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper::toDTO);
    }
}
