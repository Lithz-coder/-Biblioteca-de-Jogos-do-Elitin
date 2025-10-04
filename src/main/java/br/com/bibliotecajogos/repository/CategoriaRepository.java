package br.com.bibliotecajogos.repository;

import br.com.bibliotecajogos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Opcional, mas boa prática para indicar que é um repositório
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Nenhuma implementação necessária!
}