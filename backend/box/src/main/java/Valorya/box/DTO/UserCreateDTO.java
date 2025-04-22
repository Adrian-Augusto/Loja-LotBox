package Valorya.box.DTO;

import Valorya.box.Entity.User;
import lombok.Data;

@Data
public class UserCreateDTO {

    private String nome;
    private String email;
    private String senha;
}
