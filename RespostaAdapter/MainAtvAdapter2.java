package RespostaAdapter;

// Interface alvo
interface ProcessadorPagamento {
    void processarPagamento(double valor);
}

// Sistema antigo que deve ser adaptado
class SistemaPagamentoLegado {
    public void efetuarPagamento(String valor) {
        System.out.println("Pagamento legado processado: R$" + valor);
    }
}

// ADAPTER - Conecta a interface moderna com o sistema legado
class AdaptadorPagamento implements ProcessadorPagamento {
    private SistemaPagamentoLegado sistemaAntigo;

    public AdaptadorPagamento() {
        this.sistemaAntigo = new SistemaPagamentoLegado();
    }

    @Override
    public void processarPagamento(double valor) {
        String quantiaFormatada = String.format("%.2f", valor).replace(".", ",");
        sistemaAntigo.efetuarPagamento(quantiaFormatada);
    }
}

// Teste de funcionamento
public class MainAtvAdapter2 {
    public static void main(String[] args) {
        System.out.println("=== Teste do sistema ===");

        // Usando o adapter
        ProcessadorPagamento processador = new AdaptadorPagamento();

        // Testes
        System.out.println("\n1. Pagamento de R$ 100,00:");
        processador.processarPagamento(100.00);

        System.out.println("\n2. Pagamento de R$ 55,75:");
        processador.processarPagamento(55.75);

        System.out.println("\n3. Pagamento de R$ 1234,56:");
        processador.processarPagamento(1234.56);

        // Teste com o sistema legado diretamente
        SistemaPagamentoLegado legado = new SistemaPagamentoLegado();
        System.out.println("\nSistema legado direto:");
        legado.efetuarPagamento("100,00");
    }
}