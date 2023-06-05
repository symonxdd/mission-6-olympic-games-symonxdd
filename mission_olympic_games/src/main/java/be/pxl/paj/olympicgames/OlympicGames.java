package be.pxl.paj.olympicgames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class OlympicGames {

	public static void main(String[] args) {
		SpringApplication.run(OlympicGames.class, args);
	}

}
