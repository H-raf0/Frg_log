package isima.F2.TP3.ABDELLAOUI_EL_ALLALI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		logger.warn("Hello Word");
		logger.debug("Hello Word " + StringUtils.reverse("El Allali") + " " + StringUtils.reverse("ABDELLAOUI"));

	}

}
