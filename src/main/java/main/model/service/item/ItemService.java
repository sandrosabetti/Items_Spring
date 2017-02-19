package main.model.service.item;

import main.model.entity.Item;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ItemService {

    private EntityManager em = Persistence.createEntityManagerFactory("entityManager").createEntityManager();

    public Item add(Item item) {
        em.getTransaction().begin();
        Item itemFromDB = em.merge(item);
        em.getTransaction().commit();
        return itemFromDB;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Item get(long id) {
        return em.find(Item.class, id);
    }

    public void update(Item item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    public List<Item> getAll() {
        TypedQuery<Item> namedQuery = em.createNamedQuery("Item.getAll", Item.class);
        return namedQuery.getResultList();
    }

}