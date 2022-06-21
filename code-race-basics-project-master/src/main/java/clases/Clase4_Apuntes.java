package clases;

import Figurita.Figurita;
import Figurita.Pagina;
import util.IOUtil;

import java.util.ArrayList;
import java.util.List;

public class Clase4_Apuntes {
    public static void main () {

        /*
        List<Animal> animalList = new ArrayList<>();

        Dog dog1 = new Dog("Lola", true);
        Cat cat1 = new Cat("Tsuki", false);

        animalList.add(dog1);
        animalList.add(cat1);

        animalList.forEach(Animal::express);
        */

        final List<Figurita> figuritasPersona1 = new ArrayList<>();
        final List<Figurita> figuritasPersona2 = new ArrayList<>();

        figuritasPersona1.add(new Figurita(1, false));
        figuritasPersona1.add(new Figurita(34, true));
        figuritasPersona1.add(new Figurita(16, true));
        figuritasPersona1.add(new Figurita(44, false));
        figuritasPersona1.add(new Figurita(23, false));

        figuritasPersona2.add(new Figurita(12, true));
        figuritasPersona2.add(new Figurita(1, false));
        figuritasPersona2.add(new Figurita(16, true));
        figuritasPersona2.add(new Figurita(3, false));
        figuritasPersona2.add(new Figurita(22, true));

        /*
        figuritasPersona2.forEach(figurita -> {
            if (figuritasPersona1.contains(figurita)) {   // se fija si la lista contiene el objeto en algún lugar
                IOUtil.print(figurita + ": late");
            } else {
                IOUtil.print(figurita + ": nola");
            }
        });
        */

        final Figurita f1 = new Figurita (1, false);
        final Figurita f2 = new Figurita (2, false);
        final Figurita f3 = new Figurita (3, false);
        final Figurita f4 = new Figurita (4, false);
        final Figurita f5 = new Figurita (5,false);
        final Figurita f6 = new Figurita (6,false);
        final Figurita f7 = new Figurita (7,false);
        final Figurita f8 = new Figurita (8,false);
        final Figurita f9 = new Figurita (9,false);
        final Figurita f10 = new Figurita (10,false);
        final Figurita f11 = new Figurita (11,false);

        final Figurita fEscudo = new Figurita (12, false);

        Pagina argPagina = new Pagina(null, new ArrayList<>());

        argPagina.addJugador(f1);
        argPagina.addJugador(f2);
        argPagina.addJugador(f3);
        argPagina.addJugador(f4);
        argPagina.addJugador(f5);
        argPagina.addJugador(f6);
        argPagina.addJugador(f7);
        argPagina.addJugador(f8);
        argPagina.addJugador(f9);
        argPagina.addJugador(f10);
        argPagina.addJugador(f11);

        argPagina.setEscudo(fEscudo);

        IOUtil.print(argPagina);
    }
}
