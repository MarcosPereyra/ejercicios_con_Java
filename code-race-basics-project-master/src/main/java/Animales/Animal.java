package Animales;

import util.IOUtil;

public abstract class Animal {
    protected final String name;
    protected final boolean speaker;
    private final String expression;

    public Animal(String name, boolean speaker, String expression) {
        this.name = name;
        this.speaker = speaker;
        this.expression = expression;
    }

    public void express () {
        if (speaker) {
            IOUtil.print(String.format("%s: Hola, me llamo %s, digo guau y camino en cuatro patas", name, name));
        } else {
            IOUtil.print(String.format("%s: digo %s y camino en cuatro patas", name, expression));
        }
    }
}
