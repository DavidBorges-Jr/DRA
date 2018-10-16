package daogenerico;

import javax.persistence.EntityManager;

public class GenericDAO <T> {
    
    private final EntityManager entityManager;
    
    public GenericDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void save(T obj){
        try{
            System.out.println("Iniciando o begin");
            entityManager.getTransaction().begin();
            System.out.println("Iniciando o persist");
            entityManager.persist(obj);
            System.out.println("Iniciando o commit");
            entityManager.getTransaction().commit();
            System.out.println("Dentro do commit");
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        System.out.println("salvando.." + obj.getClass().getName());
    }
    
    public void update(T obj){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        System.out.println("alterando.." + obj.getClass().getName());

    }
    
    public void remove(Class<T> obj, Long id){
        T t = findById(obj, id);
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        System.out.println("excluindo.." + obj.getName());

    }
    
    public T findById(Class<T> obj, Long id){
        System.out.println("bucando por id.." + obj.getName());
        return entityManager.find(obj, id);
    }
    
}
