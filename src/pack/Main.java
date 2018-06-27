package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pack.logs.LoggingService;

/**
 * Created by Fresher on 27/06/2018.
 */

@SpringBootApplication
public class Main implements CommandLineRunner {


    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private LoggingService loggingService;


    public static void main(String... args) {

        // todo: init config here, if necessary

        SpringApplication.run(Main.class, args);
        //.getLogger().info("It works");
        System.out.println();

    }

    @Override
    public void run(String... strings) throws Exception {
        loggingService.getLogger().info("Run");
    }
}
