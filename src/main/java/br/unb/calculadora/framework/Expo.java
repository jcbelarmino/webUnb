package br.unb.calculadora.framework;

/**
 *
 * @author jean
 */
public class Expo extends Operacao {

    public Expo(Nodo esquerda, Nodo direita) {
        super(esquerda, direita);
    }

    @Override
    protected int executa(int esquerda, int direita) {
        return (int)Math.pow(esquerda, direita);
    }

    @Override
    protected String simbolo() {
        return "^";
    }
}
