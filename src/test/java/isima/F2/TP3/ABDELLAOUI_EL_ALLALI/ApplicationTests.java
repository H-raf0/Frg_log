package isima.F2.TP3.ABDELLAOUI_EL_ALLALI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/*
import org.junit.Test;
import static org.junit.Assert.*;
*/
@SpringBootTest
class ApplicationTests {

	Application m = new Application();
	
	@Test public void km_5()   { assertEquals(7.50, m.calcIndemnite(5), 0.01); }
    @Test public void km_15()  { assertEquals(15.90, m.calcIndemnite(15), 0.01); }
    @Test public void km_50()  { assertEquals(30.2, m.calcIndemnite(50), 0.01); }

    // Frontières de tranches
    @Test public void km_0()   { assertEquals(0.00, m.calcIndemnite(0), 0.01); }
    @Test public void km_9()   { assertEquals(13.50, m.calcIndemnite(9), 0.01); }
    @Test public void km_10()  { assertEquals(13.90, m.calcIndemnite(10), 0.01); }
    @Test public void km_39()  { assertEquals(25.50, m.calcIndemnite(39), 0.01); }
    @Test public void km_40()  { assertEquals(25.9, m.calcIndemnite(40), 0.01); }
    @Test public void km_60()  { assertEquals(35.7, m.calcIndemnite(60), 0.01); }
    @Test public void km_61()  { assertEquals(36.25, m.calcIndemnite(61), 0.01); }
    @Test public void km_80()  { assertEquals(46.7, m.calcIndemnite(80), 0.01); }
    @Test public void km_81()  { assertEquals(47.25, m.calcIndemnite(81), 0.01); }

	/*
	@Test
    public void testCalccalcIndemnite() {
        // -10, 0, 0.1, 17.123, 39.5, 61, 81, 99
        Application m = new Application();
        assertEquals(7.5f, m.calccalcIndemnite(5), 0.01f);   // exemple
        assertEquals(13.9f, m.calccalcIndemnite(10), 0.01f);
        assertEquals(17.9f, m.calccalcIndemnite(20), 0.01f);
    }*/

}
