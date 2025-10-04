// Local do arquivo: src/main/java/br/com/bibliotecajogos/config/DataInitializer.java
package br.com.bibliotecajogos.config;

import br.com.bibliotecajogos.entity.Jogo;
import br.com.bibliotecajogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private JogoRepository jogoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se o banco de dados já tem jogos para não inserir novamente
        if (jogoRepository.count() == 0) {
            System.out.println(">>> [DataInitializer] Populando banco de dados de desenvolvimento...");

            Jogo w1 = new Jogo("Watch Dogs", "Ubisoft Montreal", "Ação-Aventura", 2014, false, "https://upload.wikimedia.org/wikipedia/pt/b/b3/Watch_Dogs_capa.png");
            Jogo w2 = new Jogo("Watch Dogs 2", "Ubisoft Montreal", "Ação-Aventura", 2016, true, "https://upload.wikimedia.org/wikipedia/pt/b/b8/Watch_Dogs_2_capa.png");
            Jogo gta5 = new Jogo("Grand Theft Auto V", "Rockstar North", "Ação-Aventura", 2013, true, "https://upload.wikimedia.org/wikipedia/pt/8/80/Grand_Theft_Auto_V_capa.png");
            Jogo gta6 = new Jogo("Grand Theft Auto VI", "Rockstar Games", "Ação-Aventura", 2025, false, ""); // URL da capa vazia por enquanto
            Jogo gow1 = new Jogo("God of War", "Santa Monica Studio", "Ação-Aventura", 2005, true, "");
            Jogo gow2 = new Jogo("God of War II", "Santa Monica Studio", "Ação-Aventura", 2007, true, "");
            Jogo gow3 = new Jogo("God of War III", "Santa Monica Studio", "Ação-Aventura", 2010, true, "");
            Jogo gow2018 = new Jogo("God of War", "Santa Monica Studio", "Ação-Aventura", 2018, true, "https://upload.wikimedia.org/wikipedia/pt/8/82/God_of_War_2018_capa.png");
            Jogo ragnarok = new Jogo("God of War Ragnarök", "Santa Monica Studio", "Ação-Aventura", 2022, false, "https://upload.wikimedia.org/wikipedia/pt/a/a5/God_of_War_Ragnar%C3%B6k_capa.png");

            // Salva todos os jogos de uma vez no banco de dados
            jogoRepository.saveAll(List.of(w1, w2, gta5, gta6, gow1, gow2, gow3, gow2018, ragnarok));
            
            System.out.println(">>> [DataInitializer] Banco de dados populado com sucesso!");
        } else {
            System.out.println(">>> [DataInitializer] O banco de dados já contém dados. Nenhuma ação necessária.");
        }
    }
}
