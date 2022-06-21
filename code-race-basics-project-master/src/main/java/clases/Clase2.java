package clases;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.IOUtil.*;

public class Clase2{

    public static void main() {

        // MÉTODOS CON STRINGS

        final String name = stringInput("Ingrese su nombre:");
        int num = intInput("Ingrese su edad:");

        final String numToString = String.valueOf(num);   // convierte un dato a sttring
        print(numToString);

        print("//////////////////////////////////////////////////////////////////////");

        print(String.format("Hola %s, tenés %s años.", name, num));   // interpreta las %s como cada variable, siguiendo el orden

        print("//////////////////////////////////////////////////////////////////////");

        final String frase = "Un poroto de la maquinaria tanguera";

        print(frase);
        print(frase.replace("poroto", "engranaje"));

        print("//////////////////////////////////////////////////////////////////////");

        boolean haveWord = frase.contains("poroto");  // true
        boolean haveWord2 = frase.contains("engranaje");  // false

        print(haveWord);
        print(haveWord2);

        print("//////////////////////////////////////////////////////////////////////");

        final String newFrase = frase
                .toUpperCase()
                .replace("poroto", "engranaje");
        print(newFrase);

        print("//////////////////////////////////////////////////////////////////////");

        print("La primera A está en la posición " + newFrase.indexOf("A"));   // sólo la primera "A"
        print("Tenemos otra A en " + newFrase.indexOf("A", 20));   // sólo la primera "A"

        print("//////////////////////////////////////////////////////////////////////");

        print("La frase tiene " + frase.length() + " letras,");
        print(" y la mitad es " + frase.length() / 2);

        print("//////////////////////////////////////////////////////////////////////");

        print("Recorto el fragmento ´" + frase.substring(3, 17) + "´ de la frase");

        print("//////////////////////////////////////////////////////////////////////");

        // MÉTODO LOCALDATE

        final LocalDateTime hoy = LocalDateTime.now();
        print(hoy);

        final ZoneId utc = ZoneId.of("UTC");            // hora "universal"
        final LocalDateTime hoyEnUTC = LocalDateTime.now(utc);

        print(hoyEnUTC);

        print("//////////////////////////////////////////////////////////////////////");

        // ARRAYS

        String[] arrayEjemplo = new String[] {"Hola", ",¿cómo ", "estás? ", "Yo ", "muy ", "bien."};
        print(arrayEjemplo[3]);

        // LISTAS

        List<String> listaEjemplo = new ArrayList<>();
        listaEjemplo.add("Marcos");
        listaEjemplo.add("Pereyra");
        listaEjemplo.add("tiene 24 años");

        final String frag1 = listaEjemplo.get(0);
        final String frag2 = listaEjemplo.get(1);
        final String frag3 = listaEjemplo.get(2);

        print(listaEjemplo.size());
        final String fraseDeLista = String.format("La lista dice: `%s %s %s", frag1, frag2, frag3);
        print(fraseDeLista);

        print("//////////////////////////////////////////////////////////////////////");

        // MAP

        Map<String, String> listaMap = new HashMap<>();
        listaMap.put("Nombre", "Marcos");
        listaMap.put("Apellido", "Pereyra");
        listaMap.put("Edad", "24");

        print(listaMap.get("Apellido"));

        print("//////////////////////////////////////////////////////////////////////");

        // FOR

        for(int i = 0; i < arrayEjemplo.length; i++) {
                print(i + "- " + arrayEjemplo[i]);
        }

        print("//////////////////////////////////////////////////////////////////////");

        // FOR EACH
        print("Palabras con ´o´:");
        for (String palabras : arrayEjemplo) {    // recorro la lista, y si la palabra tiene "0", la imprimo
            if (palabras.contains("o")) {
                print(palabras);
            }
        }

        for (Map.Entry<String, String> entry : listaMap.entrySet()) {               // los entry son cada put, con su key y value
            print(String.format("El key es %s, y el value es %s", entry.getKey(), entry.getValue()));
        }

        print("//////////////////////////////////////////////////////////////////////");

        // WHILE

        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("Lucía");
        listaDeNombres.add("Gerardo");
        listaDeNombres.add("Marcos");
        listaDeNombres.add("Damián");
        listaDeNombres.add("Valentina");

        int index = 0;
        boolean found = false;
        String nameFounded = "";

        // mientras found sea true (!false) y el index sea menor que el largo de la lista (o sea, se complete la lista), hacer...
        while (!found && index < listaDeNombres.size()) {
            if (listaDeNombres.get(index).equals("Marcos")) {  // si la posición i es igual a "..."
                found = true;                                  // cambiar a true (entonces el while corta)
                nameFounded = listaDeNombres.get(index);       // guardo la variable
            }
            index ++;                                          // sumo 1 para que el index pueda avanzar
        }
        if (found) {
            print(nameFounded + " se encuentra en la posición " + index + " de la lista");
        } else {
            print("No se encontró el nombre");
        }

        print("//////////////////////////////////////////////////////////////////////" + "\n\n");
        // ENUM

        final DayOfWeek[] dayOfTheWeek = DayOfWeek.values();  // creo un array con los valores del ENUM

        for (DayOfWeek day : DayOfWeek.values()) {
            print("día -> " + day);
        }

        Map<DayOfWeek, String> listaDeDiasUsandoENUM = new HashMap<>();
        listaDeDiasUsandoENUM.put(DayOfWeek.MONDAY, "Día lunes");
        listaDeDiasUsandoENUM.put(DayOfWeek.TUESDAY, "Día martes");
        listaDeDiasUsandoENUM.put(DayOfWeek.WEDNESDAY, "Día miércoles");
        listaDeDiasUsandoENUM.put(DayOfWeek.THURSDAY, "Día jueves");
        listaDeDiasUsandoENUM.put(DayOfWeek.FRIDAY, "Día viernes");
        listaDeDiasUsandoENUM.put(DayOfWeek.SATURDAY, "Día sábado");
        listaDeDiasUsandoENUM.put(DayOfWeek.SUNDAY, "Día domingo");

        print(listaDeDiasUsandoENUM.get(DayOfWeek.MONDAY));    // me imprime "Día lunes"
    }
}
