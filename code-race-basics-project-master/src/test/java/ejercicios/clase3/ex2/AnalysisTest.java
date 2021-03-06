package ejercicios.clase3.ex2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    @DisplayName("hasCovid | given three symptoms | should return true")
    void hasCodeVidTrueThreeSymptoms () {
        final Person person = new Person(40, true, 30);

        assertTrue(Analysis.hasCodeVid(person));
    }
    @Test
    @DisplayName("hasCovid | given two symptoms | should return true")
    void hasCodeVidTrueTwoSymptoms () {
        final Person person = new Person(37, true, 10);

        assertTrue(Analysis.hasCodeVid(person));
    }
    @Test
    @DisplayName("hasCovid | given one symptoms | should return false")
    void hasCodeVidFalse () {
        final Person person = new Person(36, false, 30);

        assertFalse(Analysis.hasCodeVid(person));
    }

    @Test
    @DisplayName("hasCovid | given no symptoms | should return false")
    void hasCodeVidNoSymptomsFalse () {
        final Person person = new Person(36, false, 12);

        assertFalse(Analysis.hasCodeVid(person));
    }

    @Test
    @DisplayName("checkForQuarantine | given 50% of positives and most with fever | ok")
    void checkForQuarantine_50_mostWithFeverOk() {
        // given
        List<Person> personList = new ArrayList<>();
        personList.add(createPositive(true));
        personList.add(createNegative());
        personList.add(createPositive(true));
        personList.add(createPositive(true));
        personList.add(createNegative());
        personList.add(createNegative());

        // when
        final City city = new City("test-city", personList);

        final Quarantine quarantine = Analysis.checkForQuarantine(city);

        // then
        assertAll("Expected quarantine",
                () -> assertEquals(city, quarantine.getCity()),
                () -> assertEquals(15, quarantine.getDays()),
                () -> assertFalse(quarantine.isAntiFeverMeds())
                );
    }

    @Test
    @DisplayName("checkForQuarantine | given 81% of positives and most without fever | ok")
    void checkForQuarantine_81_mostWithoutFeverOk() {
        // given
        List<Person> personList = new ArrayList<>();
        personList.add(createPositive(true));
        personList.add(createNegative());
        personList.add(createPositive(false));
        personList.add(createPositive(true));
        personList.add(createPositive(false));
        personList.add(createPositive(false));

        // when
        final City city = new City("test-city", personList);

        final Quarantine quarantine = Analysis.checkForQuarantine(city);

        // then
        assertAll("Expected quarantine",
                () -> assertEquals(city, quarantine.getCity()),
                () -> assertEquals(30, quarantine.getDays()),
                () -> assertFalse(quarantine.isAntiFeverMeds())
        );
    }

    @Test
    @DisplayName("checkForQuarantine | given 49% of positives | ok | should return null")
    void checkForQuarantine_49_mostWithFeverOk() {
        // given
        List<Person> personList = new ArrayList<>();
        personList.add(createPositive(true));
        personList.add(createNegative());
        personList.add(createPositive(false));
        personList.add(createNegative());
        personList.add(createNegative());
        personList.add(createNegative());
        // when
        final City city = new City("test-city", personList);

        final Quarantine quarantine = Analysis.checkForQuarantine(city);

        // then
        assertNull(quarantine);
    }

    private Person createPositive (boolean withFever) {
        final Person person;

        if (withFever) {
            person = new Person (38, true, 30);
        } else {
            person = new Person (36, true, 30);
        }

        return person;
    }

    private Person createNegative () {
        return new Person(36, false, 10);
    }
}