package abolfazl.common;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPA {
    private static final EntityManager ENTITY_MANAGER = Persistence
            .createEntityManagerFactory("J2OS")
            .createEntityManager();

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}
