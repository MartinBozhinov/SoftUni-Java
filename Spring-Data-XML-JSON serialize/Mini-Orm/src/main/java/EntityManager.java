import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Arrays;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Id {

    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Entity {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Column {
        String name();
    }


    public EntityManager(Connection connection) {
        this.connection = connection;
    }



    private Field getId(Class<?> entity){
       return Arrays.stream(entity.getDeclaredFields())
               .filter(x -> x.isAnnotationPresent(Id.class))
               .findFirst()
               .orElseThrow(() -> new UnsupportedOperationException("Entity does not have primary key"));
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException {
        Field primaryKey =  getId(entity.getClass());
        primaryKey.setAccessible(true);
        Object value = primaryKey.get(entity);
        if (value == null || (long) value <=0 ){
            return doInsert(entity,primaryKey);
        }
        return doUpdate(entity,primaryKey);
    }

    private boolean doUpdate(E entity, Field primaryKey) {


    }

    private boolean doInsert(E entity, Field primaryKey) {
        

    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        return null;
    }
}
