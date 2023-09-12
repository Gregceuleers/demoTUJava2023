package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@DisplayName("MA classe de test")
public class PersonTests {

    Personne p = new Personne("Toto", "Tata", LocalDate.of(1999,1,1), true);
    List<String> maListe = List.of("Toto", "1",
            "ll", "Bonjour");

    @BeforeEach
    void setUp() {
        p = new Personne("Toto", "Tata", LocalDate.of(1999,1,1), true);
    }

    @Test
    void getterTest() {
        assertEquals("Toto", p.getFirstname());
        p.setLastname("Tutu");
    }

    @Test
    void getterSuiteTest() {
        assertEquals("Tata", p.getLastname());
    }

    @Test
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a status message");
    }

    @RepeatedTest(4)
    void repeatedTestOnList(RepetitionInfo repetitionInfo) {
        assertNotNull(maListe.get(repetitionInfo.getCurrentRepetition() - 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {93,2,3,4,5,6,7,8,9})
    void parameterizedTest(int data) {
        assertTrue(data % 2 == 0);
    }
}
