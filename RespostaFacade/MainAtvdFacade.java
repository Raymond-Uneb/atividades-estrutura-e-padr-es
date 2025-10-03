package RespostaFacade;

// Subsistemas complexos do jogo

class Mapa {
    public void carregarMapa() {
        System.out.println("Mapa pronto pra jogar!");
    }
}

class Inventario {
    public void adicionarItensIniciais() {
        System.out.println("Itens iniciais adicionados ao inventário");
    }
}

class Combate {
    public void ativar() {
        System.out.println("Combate ativado...");
    }
}

// facade simplificando a interação com os subsistemas

class JogoFacade {
    private Mapa mapa;
    private Inventario inventario;
    private Combate combate;
    
    public JogoFacade() {
        mapa = new Mapa();
        inventario = new Inventario();
        combate = new Combate();
    }
    
    public void iniciarJogo() {
        mapa.carregarMapa();
        inventario.adicionarItensIniciais();
        combate.ativar();
        System.out.println("Que os jogos comecem >:)");
    }
}

// classe principal de teste

public class MainAtvdFacade {
    public static void main(String[] args) {
        JogoFacade jogo = new JogoFacade();
        jogo.iniciarJogo();
    }
}