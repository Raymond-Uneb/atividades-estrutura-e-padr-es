package RespostaTemplate;

abstract class Entidade {

    public final void Passo() {
        colisao();
        atirar();
        mover();
    }

    private void colisao() {
        System.out.println("Colisao");
    }

    protected abstract void atirar();

    protected abstract void mover();
}

class Alien extends Entidade {
    @Override
    protected void atirar() {
        System.out.println("Alien atirando");
    }

    @Override
    protected void mover() {
        System.out.println("Alien movendo");
    }
}

class Robo extends Entidade {
    @Override
    protected void atirar() {
        System.out.println("Robo atirando");
    }

    @Override
    protected void mover() {
        System.out.println("Robo movendo");
    }
}

public class MainAtvdTemplate {
    public static void main(String[] args) {
        Entidade alien = new Alien();
        Entidade robo = new Robo();
        alien.Passo();
        robo.Passo();
    }
}