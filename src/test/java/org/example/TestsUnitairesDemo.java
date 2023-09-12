package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TestsUnitairesDemo {

    // Méthode à tester (à but pédagogique)
    int addition(int a, int b) {

        if (a == 0) throw new ArithmeticException("Addition avec ZERO non permise !");

        return a + b;
    }

    boolean maCondition() {
        return true;
    }

    @Test
    void monPremierTest_Reussite() {
        // Arrange
        int a = 5, b = 2, expected = 7;

        // Act
        int resultat = addition(a,b);

        // Assert
        assertEquals(expected, resultat);
    }

    @Test
    void monPremierTest_ResultatEchec() {
        // Arrange
        int a = 5, b = 2, expectedFoireux = 8;

        // Act & Assert
        assertNotEquals(expectedFoireux, addition(a,b));
    }

    @Test
    void monPremierTest_SiAVautZero_ExceptionPropagee() {
        // Arrange
        int a = 0, b = 5;

        // Act& Assert
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            addition(a,b);
        });
        assertEquals("Addition avec ZERO non permise !", e.getMessage());
        assertTrue(
                this::maCondition
        );
    }

    @Nested
    class PersonneTests {

        @Test
        void personneTest() {
            // Arrange
            Personne p = new Personne(
                    "Greg",
                    "Ceuleers",
                    LocalDate.of(1980,6,26),
                    true
            );

            assertAll(
                    "gettersPersonne",
                    () -> assertEquals("Ceuleers", p.getLastname()),
                    () -> assertEquals("Greg", p.getFirstname()),
                    () -> assertEquals(LocalDate.of(1980,6,26), p.getBirthday()),
                    () -> assertTrue(p.isActive())
                    );


        }

    }

}
