package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private MessagesDAO messageDAO;
	
	 @Autowired
	public Application(MessagesDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
	public void run(String... arg0) throws Exception {
    	messageDAO.initializeTables();
    	
    }

}