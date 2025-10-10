package br.com.bibliotecajogos.config;

import br.com.bibliotecajogos.entity.Categoria; // Importe a Categoria
import br.com.bibliotecajogos.entity.Jogo;
import br.com.bibliotecajogos.repository.CategoriaRepository; // Importe o Repository da Categoria
import br.com.bibliotecajogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired // Injete o CategoriaRepository
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se o banco já tem dados
        if (jogoRepository.count() == 0 && categoriaRepository.count() == 0) {
            System.out.println(">>> [DataInitializer] Populando banco de dados de desenvolvimento...");

            // 1. CRIE E SALVE A CATEGORIA PRIMEIRO
            Categoria acaoAventura = new Categoria("Ação-Aventura");
            categoriaRepository.save(acaoAventura);

            // 2. AGORA CRIE OS JOGOS COM OS PARÂMETROS NA ORDEM CORRETA E PASSANDO A CATEGORIA
            // Construtor: Jogo(String titulo, String autor, Integer anoPublicacao, String genero, String urlCapa, boolean finalizado, Categoria categoria)
            
            Jogo w1 = new Jogo("Watch Dogs", "Ubisoft Montreal", 2014, "Ação-Aventura", "https://upload.wikimedia.org/wikipedia/pt/b/b3/Watch_Dogs_capa.png", false, acaoAventura);
            Jogo w2 = new Jogo("Watch Dogs 2", "Ubisoft Montreal", 2016, "Ação-Aventura", "https://upload.wikimedia.org/wikipedia/pt/b/b8/Watch_Dogs_2_capa.png", true, acaoAventura);
            Jogo gta5 = new Jogo("Grand Theft Auto V", "Rockstar North", 2013, "Ação-Aventura", "https://upload.wikimedia.org/wikipedia/pt/8/80/Grand_Theft_Auto_V_capa.png", true, acaoAventura);
            Jogo gta6 = new Jogo("Grand Theft Auto VI", "Rockstar Games", 2025, "Ação-Aventura", "", false, acaoAventura);
            Jogo gow1 = new Jogo("God of War", "Santa Monica Studio", 2005, "Ação-Aventura", "", true, acaoAventura);
            Jogo gow2 = new Jogo("God of War II", "Santa Monica Studio", 2007, "Ação-Aventura", "", true, acaoAventura);
            Jogo gow3 = new Jogo("God of War III", "Santa Monica Studio", 2010, "Ação-Aventura", "", true, acaoAventura);
            Jogo gow2018 = new Jogo("God of War", "Santa Monica Studio", 2018, "Ação-Aventura", "https://upload.wikimedia.org/wikipedia/pt/8/82/God_of_War_2018_capa.png", true, acaoAventura);
            Jogo ragnarok = new Jogo("God of War Ragnarök", "Santa Monica Studio", 2022, "Ação-Aventura", "https://upload.wikimedia.org/wikipedia/pt/a/a5/God_of_War_Ragnar%C3%B6k_capa.png", false, acaoAventura);

            // 3. Salva todos os jogos de uma vez no banco de dados
            jogoRepository.saveAll(List.of(w1, w2, gta5, gta6, gow1, gow2, gow3, gow2018, ragnarok));
            
            System.out.println(">>> [DataInitializer] Banco de dados populado com sucesso!");
        } else {
            System.out.println(">>> [DataInitializer] O banco de dados já contém dados. Nenhuma ação necessária.");
        }
    }
}
