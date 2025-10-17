package isima.F2.TP3.ABDELLAOUI_EL_ALLALI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    Application m = new Application();

    // Cas simples
    @Test void km_0()   { assertEquals(0.0, m.calcIndemnite(0), 0.01); }
    @Test void km_5()   { assertEquals(7.5, m.calcIndemnite(5), 0.01); }
    @Test void km_10()  { assertEquals(13.9, m.calcIndemnite(10), 0.01); }

    // Frontières tranches
    @Test void km_9()   { assertEquals(13.5, m.calcIndemnite(9), 0.01); }
    @Test void km_39()  { assertEquals(25.5, m.calcIndemnite(39), 0.01); }
    @Test void km_40()  { assertEquals(25.9, m.calcIndemnite(40), 0.01); }
    @Test void km_59()  { assertEquals(35.15, m.calcIndemnite(59), 0.01); }
    @Test void km_60()  { assertEquals(35.7, m.calcIndemnite(60), 0.01); }
    @Test void km_61()  { assertEquals(36.25, m.calcIndemnite(61), 0.01); }
    @Test void km_80()  { assertEquals(46.7, m.calcIndemnite(80), 0.01); }
    @Test void km_81()  { assertEquals(47.25, m.calcIndemnite(81), 0.01); }

    // Cas pour la dernière tranche (kmRestant / 20)
    @Test void km_100() { assertEquals(57.7, m.calcIndemnite(100), 0.01); }
    @Test void km_120() { assertEquals(65.97, m.calcIndemnite(120), 0.01); }

    // Cas négatif
    @Test void km_negatif() { assertEquals(0.0, m.calcIndemnite(-10), 0.01); }

    // Cas pour tester la boucle avec toutes les tranches
    @Test void km_8()   { assertEquals(12.0, m.calcIndemnite(8), 0.01); }
    @Test void km_15()  { assertEquals(15.9, m.calcIndemnite(15), 0.01); }
    @Test void km_50()  { assertEquals(30.2, m.calcIndemnite(50), 0.01); }

    // Test main (pour coverage complet)
    @Test void testMain() {
        Application.main(new String[]{});
    }
}
