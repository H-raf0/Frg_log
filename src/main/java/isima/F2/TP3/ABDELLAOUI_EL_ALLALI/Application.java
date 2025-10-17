package isima.F2.TP3.ABDELLAOUI_EL_ALLALI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public float calcIndemnite(int nbKm) {
        float indemnite = 0.0f;

        // Définir les tranches et tarifs
        int[] tranches = { 9, 39, 59 };           // km limites pour chaque tranche
        float[] tarifs = { 1.5f, 0.4f, 0.55f };  // tarifs correspondants
        float tarifDernier = 6.81f;              // tarif pour km restant

        int kmRestant = nbKm;

        for (int i = 0; i < tranches.length; i++) {
            if (kmRestant > 0) {
                int kmDansTranche = Math.min(kmRestant, tranches[i]);
                indemnite += kmDansTranche * tarifs[i];
                kmRestant -= kmDansTranche;
            }
        }

        // Dernière tranche
        if (kmRestant > 0) {
            indemnite += (kmRestant/20.0f) * tarifDernier;
        }

        return indemnite;
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Application m = new Application();

        // Tests manuels
        int[] kmTests = { 5, 10, 20, 50, 100 };

        for (int km : kmTests) {
            float indemnite = m.calcIndemnite(km);
            logger.info("nb_km = {} -> indemnite = {}", km, indemnite);
        }
	}

}
