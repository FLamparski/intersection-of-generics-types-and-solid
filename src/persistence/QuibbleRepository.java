package persistence;

import java.util.Collection;

import model.Quibble;

/**
 * This is a {@link Repository} specialisation for {@link Quibble}s.
 * Quibbles have a zimpkin which can be used to retrieve zero or more
 * of them, and this operation is defined here.
 * @author filip
 *
 */
public interface QuibbleRepository extends Repository<Quibble> {
	/**
	 * Search quibbles by their zimpkin property.
	 * @param zimpkin The full or partial zimpkin to search for.
	 * @return The collection of quibbles that match the zimpkin given.
	 */
	Collection<Quibble> findByZimpkin(String zimpkin);
}
