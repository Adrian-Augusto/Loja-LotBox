package Valorya.box.Service;

import Valorya.box.Entity.Produto;
import Valorya.box.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository; // aqui é um repositório, não uma lista!

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
