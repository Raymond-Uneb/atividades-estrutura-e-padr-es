package RespostaFacade;

// ========== SUBSISTEMAS COMPLEXOS ==========

class Mapa {
    public void carregarMapa() {
        System.out.println("Mapa carregado com sucesso.");
    }
}

class Inventario {
    public void adicionarItensIniciais() {
        System.out.println("Itens iniciais adicionados ao inventário.");
    }
}

class Combate {
    public void ativar() {
        System.out.println("Sistema de combate ativado.");
    }
}

// ========== FACADE (INTERFACE SIMPLIFICADA) ==========

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
        System.out.println("Jogo iniciado! Boa aventura");
    }
}

// ========== CLASSE PRINCIPAL ==========

public class MainAtvdFacade {
    public static void main(String[] args) {
        JogoFacade jogo = new JogoFacade();
        jogo.iniciarJogo();
    }
}