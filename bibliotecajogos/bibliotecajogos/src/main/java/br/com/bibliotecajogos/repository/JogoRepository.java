package br.com.bibliotecajogos.repository;

import br.com.bibliotecajogos.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    /**
     * O Spring Data JPA cria a query automaticamente baseada no nome do método.
     * "findBy" -> Indica uma busca.
     * "Titulo" -> O nome do atributo na classe Jogo.
     * "Containing" -> Corresponde a um 'LIKE %termo%'.
     * "IgnoreCase" -> Ignora se as letras são maiúsculas ou minúsculas.
     */
    List<Jogo> findByTituloContainingIgnoreCase(String titulo);

    List<Jogo> findByAutorContainingIgnoreCase(String autor);

    List<Jogo> findByGeneroContainingIgnoreCase(String genero);
}