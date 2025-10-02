package RespostaBridge;

// ========== IMPLEMENTAÇÃO (CANAL) ==========
interface Canal {
    void enviar(String mensagem);
}

class Email implements Canal {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando por Email: " + mensagem);
    }
}

class SMS implements Canal {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando por SMS: " + mensagem);
    }
}

// ========== ABSTRAÇÃO (MENSAGEM) ==========
abstract class Mensagem {
    protected Canal canal;
    
    public Mensagem(Canal canal) {
        this.canal = canal;
    }
    
    public abstract void enviar(String mensagem);
}

// ========== ABSTRAÇÃO REFINADA ==========
class MensagemUrgente extends Mensagem {
    
    public MensagemUrgente(Canal canal) {
        super(canal);
    }
    
    @Override
    public void enviar(String mensagem) {
        // Adiciona formatação especial para mensagem urgente
        String mensagemFormatada = "-> URGENTE: " + mensagem + " <-";
        canal.enviar(mensagemFormatada);
    }
}

class MensagemNormal extends Mensagem {
    
    public MensagemNormal(Canal canal) {
        super(canal);
    }
    
    @Override
    public void enviar(String mensagem) {
        // Envia a mensagem sem formatação especial
        canal.enviar(mensagem);
    }
}

// ========== CLASSE PRINCIPAL ==========
public class MainAtvdBridge {
    public static void main(String[] args) {
        // Criando diferentes combinações usando Bridge
        
        // Mensagem urgente por Email
        Mensagem mensagem1 = new MensagemUrgente(new Email());
        
        // Mensagem urgente por SMS
        Mensagem mensagem2 = new MensagemUrgente(new SMS());
        
        // Mensagem normal por Email
        Mensagem mensagem3 = new MensagemNormal(new Email());
        
        // Mensagem normal por SMS
        Mensagem mensagem4 = new MensagemNormal(new SMS());
        
        System.out.println("=== SISTEMA DE MENSAGENS COM BRIDGE ===\n");
        
        // Testando todas as combinações
        mensagem1.enviar("Reunião cancelada!");
        mensagem2.enviar("Projeto atrasado!");
        mensagem3.enviar("Lembrete: Pagamento em dia");
        mensagem4.enviar("Código de verificação: 123456");
        
        System.out.println("\n=== DEMONSTRANDO FLEXIBILIDADE ===");
        
        // Mesma mensagem, diferentes canais
        String mesmaMensagem = "Alerta do sistema";
        Mensagem urgenteEmail = new MensagemUrgente(new Email());
        Mensagem urgenteSMS = new MensagemUrgente(new SMS());
        Mensagem normalEmail = new MensagemNormal(new Email());
        Mensagem normalSMS = new MensagemNormal(new SMS());
        
        urgenteEmail.enviar(mesmaMensagem);
        urgenteSMS.enviar(mesmaMensagem);
        normalEmail.enviar(mesmaMensagem);
        normalSMS.enviar(mesmaMensagem);
    }
}