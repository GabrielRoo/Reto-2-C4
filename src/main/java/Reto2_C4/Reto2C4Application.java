package Reto2_C4;

import Reto2_C4.Interfaces.UserInterface;
import Reto2_C4.Interfaces.CleaningProductsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2C4Application implements CommandLineRunner {
        @Autowired
        private CleaningProductsInterface cleaningProductsInterface;
        @Autowired
        private UserInterface userInterface;
            public static void main(String[] args) {
                    SpringApplication.run(Reto2C4Application.class, args);
	}
        @Override
        public void run (String... args) throws Exception{
            cleaningProductsInterface.deleteAll();
            userInterface.deleteAll();
        }

}
