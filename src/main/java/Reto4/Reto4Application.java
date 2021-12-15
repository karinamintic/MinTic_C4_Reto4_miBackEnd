package Reto4;

import Reto4.repository.Interface.OrderInterface;
import Reto4.repository.Interface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import Reto4.repository.Interface.CosmeticsInterface;

@Component
@SpringBootApplication
public class Reto4Application implements CommandLineRunner {

    @Autowired
    private OrderInterface orderInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private CosmeticsInterface cosmeticsInterface;

    public static void main(String[] args) {
        SpringApplication.run(Reto4Application.class, args);
    }

	@Override
    public void run(String... args) throws Exception {
        cosmeticsInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
    }
}
