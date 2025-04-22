package Valorya.box.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "A descrição do produto é obrigatória")
    @Size(max = 500, message = "A descrição pode ter no máximo 500 caracteres")
    private String descricao;

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser positivo")
    private BigDecimal preco;

    // Cada produto pertence a um usuário
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

}
