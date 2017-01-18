package persistence.impl;

import java.util.Collection;

import persistence.Repository;

/**
 * A concrete class which implements {@link Repository}
 * for some technology (if we were using Hibernate,
 * this would be full of sessions and transactions).
 * 
 * This is still a generic repository but is now concretised
 * for a specific storage back-end.
 * @author filip
 *
 * @param <T> The type of object being persisted.
 */
public class RepositoryImpl<T> implements Repository<T>{
	String database;
	
	/**
	 * Basic initialisation.
	 * @param db For something like Hibernate, this would be a SessionFactory.
	 */
	public RepositoryImpl(String db) { 
		database = db;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Additionally, this all() method is now concretised
	 * for a particular storage back-end.
	 */
	@Override
	public Collection<T> all(Class<T> class_) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Additionally, this get() method is now concretised
	 * for a particular storage back-end.
	 */
	@Override
	public T get(Class<T> class_, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Additionally, this save() method is now concretised
	 * for a particular storage back-end.
	 */
	@Override
	public T save(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Additionally, this delete() method is now concretised
	 * for a particular storage back-end.
	 */
	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		
	}
}
