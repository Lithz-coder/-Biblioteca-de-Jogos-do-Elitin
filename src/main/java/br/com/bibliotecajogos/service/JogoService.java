package br.com.bibliotecajogos.service;

import br.com.bibliotecajogos.entity.Jogo;
import br.com.bibliotecajogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 1. Anotação que marca esta classe como um componente de serviço do Spring
public class JogoService {

    // 2. Injeção de dependência: Pede ao Spring para nos entregar uma instância do JogoRepository
    @Autowired
    private JogoRepository jogoRepository;

    /**
     * Lista todos os jogos, permitindo ordenação por um campo específico.
     */
    public List<Jogo> listarTodos(String sortBy) {
        // Usa o JogoRepository para buscar todos os jogos, aplicando a ordenação
        return jogoRepository.findAll(Sort.by(sortBy));
    }

    /**
     * Salva um novo jogo ou atualiza um existente.
     */
    public Jogo salvar(Jogo jogo) {
        // Delega a ação de salvar para o repositório
        return jogoRepository.save(jogo);
    }

    /**
     * Busca um único jogo pelo seu ID.
     */
    public Jogo buscarPorId(Long id) {
        // O método findById retorna um Optional, que pode ou não conter um Jogo.
        // .orElse(null) retorna o Jogo se ele for encontrado, ou null caso contrário.
        return jogoRepository.findById(id).orElse(null);
    }

    /**
     * Exclui um jogo do banco de dados com base no ID.
     */
    public void excluir(Long id) {
        // Delega a ação de exclusão para o repositório
        jogoRepository.deleteById(id);
    }

    /**
     * Pesquisa jogos com base em um termo e um tipo de pesquisa (título, autor ou gênero).
     */
    public List<Jogo> pesquisar(String termo, String tipoPesquisa) {
        // Utiliza um switch para chamar o método de busca apropriado do repositório
        switch (tipoPesquisa) {
            case "titulo":
                return jogoRepository.findByTituloContainingIgnoreCase(termo);
            case "autor":
                return jogoRepository.findByAutorContainingIgnoreCase(termo);
            case "genero":
                return jogoRepository.findByGeneroContainingIgnoreCase(termo);
            default:
                // Se o tipo de pesquisa for inválido, retorna uma lista vazia
                return List.of();
        }
    }
}