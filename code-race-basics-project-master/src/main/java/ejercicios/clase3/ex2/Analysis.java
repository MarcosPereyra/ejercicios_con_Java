package ejercicios.clase3.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Analysis {

    private final static double FEVER_THRESHOLD = 37;       // umbrales de valores constantes (fiebre, pulsaciones, síntomas)
    private final static int UP_BEAT_THRESHOLD = 80;
    private static final int SYMPTOMS_THRESHOLD = 2;
    private static final int FIFTY_PERCENT = 50;
    private static final int EIGHTY_PERCENT = 80;
    private static final int FULL_QUARANTINE = 30;
    private static final int PARTIAL_QUARANTINE = 15;

    public static boolean hasCodeVid (Person person) {                      // método para comprobar si tiene el virus
        final List<Function<Person, Boolean>> tests = new ArrayList<>();   // creo una lista de funciones
        tests.add(Analysis::hasFever);
        tests.add(Analysis::hasCough);
        tests.add(Analysis::hasUpBeats);

        int amountOfSymptoms = 0;
        int amountOfTests = tests.size();       // cantidad de tests es igual a la cantidad de métodos
        int testIndex = 0;

        while (amountOfSymptoms < SYMPTOMS_THRESHOLD && testIndex < amountOfTests) {   // mientras la cant. de síntomas sea menor al umbral y la cant. de tests probados sea menor o igual al total...
            if (tests.get(testIndex).apply(person)) {                                  // si test 1, aplicando persona 1 es true... si test 2... si test 3...
                amountOfSymptoms ++;                                                  // sumo un síntoma
            }

            testIndex ++;                                                               // siguiente test
        }

        return amountOfSymptoms >= SYMPTOMS_THRESHOLD;      // da true o false
    }

    public static Quarantine checkForQuarantine (City city) {
        final Quarantine quarantine;

        final List<Person> people = city.getPeople();
        final List<Person> contagious = new ArrayList<>();

        final int totalPeople = people.size();

        for (Person person : people) {
            if (hasCodeVid(person)) {
                contagious.add(person);
            }
        }

        final double percentageOfContagious = (contagious.size() * 100) / totalPeople;

        if (percentageOfContagious >= FIFTY_PERCENT) {
            final boolean majorityWithFever = hasMajorityFever(contagious);
            final int days = percentageOfContagious > EIGHTY_PERCENT ? FULL_QUARANTINE : PARTIAL_QUARANTINE;

            quarantine = new Quarantine(city, days, majorityWithFever);
        } else {
            quarantine = null;
        }

        return quarantine;
    }

    private static boolean hasMajorityFever(List<Person> contagious) {
        int amountWithFever = 0;

        for (Person person : contagious) {
            if (hasFever(person)) {
                amountWithFever ++;
            }
        }

        final double percentageWithFever = contagious.size() * (amountWithFever / 100);

        return percentageWithFever >= FIFTY_PERCENT;
    }

    private static boolean hasFever (Person person) {
        return person.getTemperature() >= FEVER_THRESHOLD;
    }

    private static boolean hasCough(Person person) {
        return person.hasCough();
    }

    private static boolean hasUpBeats(Person person) {
        final int beatsPerTenSeconds = person.getBeatsPerTenSeconds();
        final int beatsPerMinute = beatsPerTenSeconds * 6;

        return beatsPerMinute >= UP_BEAT_THRESHOLD;
    }
}
