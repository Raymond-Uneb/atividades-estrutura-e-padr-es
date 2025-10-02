package RespostaFlyweight;

import java.util.HashMap;
import java.util.Map;

// Classe Carta (Flyweight)
class Carta {
    private final String nome;
    private final int custo;
    private final String efeito;

    public Carta(String nome, int custo, String efeito) {
        this.nome = nome;
        this.custo = custo;
        this.efeito = efeito;
    }

    public void exibir(int posicao) {
        System.out.println("Carta: " + nome + " | Custo: " + custo + " | Efeito: " + efeito + " | Posição na mão: " + posicao);
    }
}

// Classe CartaFactory (Flyweight Factory)
class CartaFactory {
    private static final Map<String, Carta> cartas = new HashMap<>();
    
    public static Carta getCarta(String nome, int custo, String efeito) {
        String chave = nome + "-" + custo + "-" + efeito;
        
        if (!cartas.containsKey(chave)) {
            cartas.put(chave, new Carta(nome, custo, efeito));
            System.out.println("Criando nova carta: " + nome);
        } else {
            System.out.println("Reutilizando carta existente: " + nome);
        }
        
        return cartas.get(chave);
    }
}

// Classe Principal
public class MainAtvdFlyweight {
    public static void main(String[] args) {
        
        Carta c1 = CartaFactory.getCarta("Bola de fogo", 35, "Causa dano mágico");
        Carta c2 = CartaFactory.getCarta("Curar", 10, "Recupera vida"); 
        Carta c3 = CartaFactory.getCarta("Ataque", 20, "Causa dano físico");
        
        c1.exibir(1);
        c2.exibir(2);
        c3.exibir(3);
        
        // DEMONSTRAÇÃO DO FLYWEIGHT: Reutilizando cartas existentes
        System.out.println("\n=== REUTILIZANDO CARTAS (FLYWEIGHT) ===");
        Carta c4 = CartaFactory.getCarta("Bola de fogo", 35, "Causa dano mágico"); // Reutiliza c1
        Carta c5 = CartaFactory.getCarta("Curar", 10, "Recupera vida"); // Reutiliza c2
        
        c4.exibir(4);
        c5.exibir(5);
    }
}