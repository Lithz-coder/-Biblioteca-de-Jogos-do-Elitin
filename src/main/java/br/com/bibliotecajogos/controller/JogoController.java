package br.com.bibliotecajogos.controller;

import br.com.bibliotecajogos.entity.Jogo;
import br.com.bibliotecajogos.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JogoController {

    @Autowired
    private JogoService jogoService; // VARIÁVEL CORRIGIDA (letra minúscula)

    // Mapeia a URL principal para listar todos os jogos
    @GetMapping("/jogos")
    public String listarJogos(Model model, @RequestParam(defaultValue = "titulo") String sortBy) {
        // CHAMADA CORRIGIDA (usando a variável 'jogoService')
        model.addAttribute("jogos", jogoService.listarTodos(sortBy));
        return "jogos"; // Renderiza o arquivo jogos.html
    }

    // Mapeia a URL para exibir o formulário de um novo jogo
    @GetMapping("/jogos/novo")
    public String novoJogoForm(Model model) {
        model.addAttribute("jogo", new Jogo());
        return "formulario-jogo"; // Renderiza o arquivo formulario-jogo.html
    }

    // Mapeia o envio (POST) do formulário para salvar um jogo
    @PostMapping("/jogos")
    public String salvarJogo(@ModelAttribute("jogo") Jogo jogo) {
        // CHAMADA CORRIGIDA
        jogoService.salvar(jogo);
        return "redirect:/jogos"; // Redireciona para a lista de jogos
    }

    // Mapeia a URL para editar um jogo existente
    @GetMapping("/jogos/editar/{id}")
    public String editarJogoForm(@PathVariable Long id, Model model) {
        // CHAMADA CORRIGIDA
        model.addAttribute("jogo", jogoService.buscarPorId(id));
        return "formulario-jogo";
    }

    // Mapeia a URL para excluir um jogo
    @GetMapping("/jogos/excluir/{id}")
    public String excluirJogo(@PathVariable Long id) {
        // CHAMADA CORRIGIDA
        jogoService.excluir(id);
        return "redirect:/jogos";
    }

    // Mapeia a URL para pesquisar jogos
    @GetMapping("/jogos/pesquisar")
    public String pesquisarJogos(@RequestParam String termo, @RequestParam String tipo, Model model) {
        // CHAMADA CORRIGIDA
        model.addAttribute("jogos", jogoService.pesquisar(termo, tipo));
        return "jogos";
    }

    /**
     * NOVO MÉTODO DE REDIRECIONAMENTO
     * Redireciona a rota raiz ("/") para a página principal de jogos ("/jogos").
     */
    @GetMapping("/")
    public String redirecionarParaJogos() {
        return "redirect:/jogos";
    }
}
