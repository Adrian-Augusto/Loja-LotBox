package Valorya.box.Service;

import Valorya.box.Entity.Endereco;
import Valorya.box.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public Optional<Endereco> atualizarEndereco(Long id, Endereco novoEndereco) {
        return enderecoRepository.findById(id).map(enderecoExistente -> {
            enderecoExistente.setEndereco(novoEndereco.getEndereco());
            enderecoExistente.setRua(novoEndereco.getRua());
            enderecoExistente.setEstado(novoEndereco.getEstado());
            return enderecoRepository.save(enderecoExistente);
        });
    }
}
