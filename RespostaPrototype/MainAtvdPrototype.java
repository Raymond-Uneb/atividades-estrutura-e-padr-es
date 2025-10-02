package RespostaPrototype;

interface ElementoDesign {
    ElementoDesign clone();
    void renderizar();
}

public class MainAtvdPrototype implements ElementoDesign {
    private String corFundo, corTexto, fonte;

    public MainAtvdPrototype() {

        this.corFundo = "#3498db";
        this.corTexto = "#ffffff";
        this.fonte = "Arial, 14px, bold";

    }
    public ElementoDesign clone() {
        MainAtvdPrototype clone = new MainAtvdPrototype();

        clone.corFundo = this.corFundo;
        clone.corTexto = this.corTexto;
        clone.fonte = this.fonte;
        return clone;
    }

    @Override
    public void renderizar() {

    }
}