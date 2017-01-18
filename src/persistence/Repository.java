package persistence;

import java.util.Collection;

/**
 * The base interface for every repository,
 * which contains the core functionality needed
 * to persist objects and manage persisted objects.
 * @author filip
 *
 * @param <T> The type of object being persisted.
 */
public interface Repository<T> {
	/**
	 * Gets all persisted objects of type T.
	 * @param class_ Required to make Java happy - there's no reason this couldn't be inferred at runtime except that
	 * type parameters are thrown away at compilation time, which is why you can't do <code>new T();</code> or
	 * <code>T.class</code>. The latter is what we want.
	 * @return The collection of all objects of type T persisted in whatever persistence mechanism used.
	 */
	Collection<T> all(Class<T> class_);
	
	/**
	 * Gets a persisted T by its ID.
	 * @param class_ Required to make Java happy - there's no reason this couldn't be inferred at runtime except that
	 * type parameters are thrown away at compilation time, which is why you can't do <code>new T();</code> or
	 * <code>T.class</code>. The latter is what we want.
	 * @param id The ID (primary key) of the object.
	 * @return The object, if found, or null.
	 */
	T get(Class<T> class_, long id);
	
	/**
	 * Saves this object into the store. This can involve inserting
	 * or updating the object's store representation.
	 * @param object The object to save. The <code>class_</code> parameter is
	 * not needed here as a simple <code>object.getClass()</code> will do.
	 * @return The modified object - if an insert happened, the object's ID will be set.
	 */
	T save(T object);
	
	/**
	 * Deletes an object from the store.
	 * @param object The object to delete. The <code>class_</code> parameter is
	 * not needed here as a simple <code>object.getClass()</code> will do.
	 */
	void delete(T object);
}
