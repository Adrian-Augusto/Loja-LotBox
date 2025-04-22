package Valorya.box.Mapper;

import Valorya.box.DTO.UserCreateDTO;
import Valorya.box.DTO.UserResponseDTO;
import Valorya.box.Entity.User;

public class UserMapper {

    // Converter DTO de criação para Entidade
    public static User toEntity(UserCreateDTO dto) {
        User user = new User();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());
        return user;
    }

    // Converter Entidade para DTO de resposta
    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
