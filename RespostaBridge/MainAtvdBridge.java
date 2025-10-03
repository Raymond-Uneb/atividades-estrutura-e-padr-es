package RespostaBridge;

// A implementação (CANAIS)
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

// a abstração (MENSAGENS)
abstract class Mensagem {
    protected Canal canal;
    
    public Mensagem(Canal canal) {
        this.canal = canal;
    }
    
    public abstract void enviar(String mensagem);
}

// a abstração refinada (TIPOS DE MENSAGENS)
class MensagemUrgente extends Mensagem {
    
    public MensagemUrgente(Canal canal) {
        super(canal);
    }
    
    @Override
    public void enviar(String mensagem) {
        // Colocando formataçao especial para mensagens urgentes 
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
        // Mensagem sem formataçao especial
        canal.enviar(mensagem);
    }
}

// Classe principal de teste
public class MainAtvdBridge {
    public static void main(String[] args) {
        // criando várias combinações de mensagens e canais com o BRIDGE
        
        // Mensagem urgente por Email!!!!
        Mensagem mensagemA = new MensagemUrgente(new Email());
        
        // Mensagem urgente por SMS
        Mensagem mensagemB = new MensagemUrgente(new SMS());
        
        // Mensagem normal por Email
        Mensagem mensagemC = new MensagemNormal(new Email());
        
        // Mensagem normal por SMS
        Mensagem mensagemD = new MensagemNormal(new SMS());
        
        System.out.println(" mensagens com o bridge \n");
        
        // Testando todas as combinações
        mensagemA.enviar("Reunião cabo meu povo, tem mais não!");
        mensagemB.enviar("Tao devendo projeto ae né?");
        mensagemC.enviar("Lembrendo: tem q pagar a conta!");
        mensagemD.enviar("Código pra botar lá : 5B75C4O3PY93");
        
        System.out.println("\n mostrando que é flexivel ");
        
        // Mesma mensagem, diferentes canais
        String mesmaMensagem = "ALERTA!!";
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