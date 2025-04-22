package Valorya.box.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Endereco")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(max = 255, message = "O endereço pode ter no máximo 255 caracteres")
    private String endereco;

    @NotBlank(message = "A rua é obrigatória")
    @Size(max = 100, message = "A rua pode ter no máximo 100 caracteres")
    private String rua;

    @NotBlank(message = "O estado é obrigatório")
    @Size(max = 50, message = "O estado pode ter no máximo 50 caracteres")
    private String estado;


    // opcional: bidirecional
    @OneToOne(mappedBy = "endereco")
    private User user;
}
