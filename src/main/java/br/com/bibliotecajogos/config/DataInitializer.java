package br.com.bibliotecajogos.config;

import br.com.bibliotecajogos.entity.Categoria;
import br.com.bibliotecajogos.entity.Jogo;
import br.com.bibliotecajogos.repository.CategoriaRepository;
import br.com.bibliotecajogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component // 1. Transforma a classe em um bean gerenciado pelo Spring
@Profile("dev") // 2. O Spring SÓ ativará esta classe se o perfil "dev" estiver ativo
public class DataInitializer implements CommandLineRunner { // 3. Permite executar um código na inicialização

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        // 4. Verifica se o banco já tem dados para não duplicar
        if (categoriaRepository.count() == 0) {
            System.out.println(">>> [DataInitializer] Populando banco de dados de desenvolvimento...");

            // --- Criar Categorias ---
            Categoria rpg = new Categoria();
            rpg.setNome("RPG");

            Categoria acao = new Categoria();
            acao.setNome("Ação");

            Categoria estrategia = new Categoria();
            estrategia.setNome("Estratégia");
            
            Categoria aventura = new Categoria();
            aventura.setNome("Aventura");

            // Salva todas as categorias de uma vez
            categoriaRepository.saveAll(List.of(rpg, acao, estrategia, aventura));

            // --- Criar Jogos ---
            Jogo jogo1 = new Jogo();
            jogo1.setTitulo("The Witcher 3: Wild Hunt");
            jogo1.setAutor("CD Projekt Red");
            jogo1.setAnoPublicacao(2015);
            jogo1.setGenero("RPG de Ação");
            jogo1.setCategoria(rpg); // Associa o jogo à categoria RPG
            jogo1.setFinalizado(true);
            jogo1.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/thumb/0/06/TW3_Wild_Hunt.png/270px-TW3_Wild_Hunt.png");

            Jogo jogo2 = new Jogo();
            jogo2.setTitulo("Red Dead Redemption 2");
            jogo2.setAutor("Rockstar Games");
            jogo2.setAnoPublicacao(2018);
            jogo2.setGenero("Ação-Aventura");
            jogo2.setCategoria(acao); // Associa o jogo à categoria Ação
            jogo2.setFinalizado(true);
            jogo2.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/e/e7/Red_Dead_Redemption_2.png");
            
            Jogo jogo3 = new Jogo();
            jogo3.setTitulo("Baldur's Gate 3");
            jogo3.setAutor("Larian Studios");
            jogo3.setAnoPublicacao(2023);
            jogo3.setGenero("RPG");
            jogo3.setCategoria(rpg);
            jogo3.setFinalizado(false);
            jogo3.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/1/18/Baldur%27s_Gate_III_Larian_Studios_key_art.png");

            // Salva todos os jogos de uma vez
            jogoRepository.saveAll(Arrays.asList(jogo1, jogo2, jogo3));

            System.out.println(">>> [DataInitializer] Banco de dados populado com sucesso!");
        } else {
            System.out.println(">>> [DataInitializer] O banco de dados já contém dados. Nenhuma ação foi tomada.");
        }
    }
}