import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hib_code_first")
                ;

        EntityManager entityManager = entityManagerFactory.createEntityManager();







    }
}
