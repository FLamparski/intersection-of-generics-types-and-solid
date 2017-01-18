import java.util.Collection;

import model.Quibble;
import persistence.QuibbleRepository;
import persistence.Repository;
import persistence.impl.QuibbleRepositoryImpl;

public class Program {

	public static void main(String[] args) {
		/*
		 * The code here demonstrates the dependency inversion principle,
		 * or the D in SOLID.
		 * Using this principle, we can use QuibbleRepository as the type of variables,
		 * formal parameters, etc - and only use the actual implementations to construct
		 * objects. This means that it's easier to swap out implementations of how
		 * the repository works (Hibernate vs JDBC vs REST API vs in-memory...)
		 * while keeping the semantics the same.
		 * Additionally, it shows Liskov's substitution principle (L in SOLID),
		 * as every QuibbleRepository is a Repository<Quibble>. However, it also
		 * shows that generics introduce an extra layer of "subclassing" or
		 * specialisation that has to be taken into account when thinking about
		 * Liskov.
		 */
		QuibbleRepository quibbles = new QuibbleRepositoryImpl("this is my database");
		/*
		 * Note that no type parameters or casts are needed, even though we're using a method
		 * defined with a type parameter T. The specialisation of the QuibbleRepository
		 * interface took care of "filling in" that type parameter.
		 */
		Collection<Quibble> myQuibbles = quibbles.all(Quibble.class);

		/*
		 * Exploring the types here.
		 * 
		 * Works - QuibbleRepository is a subclass of Repository<Quibble>,
		 * which is a specialisation of Repository<T>.
		 */
		Repository<Quibble> things = quibbles;
		/*
		 * Here, things has the type parameter explicitly defined,
		 * and this still works as you'd expect a generic to work.
		 */
		myQuibbles = things.all(Quibble.class);
		/*
		 * This doesn't work since things is just a Repository<Quibble>,
		 * not a QuibbleRepository. Compilation error.
		 */
		myQuibbles = things.findByZimpkin("booyah");
		/*
		 * compilation error - even though QuibbleRepository is a subclass of Repository,
		 * it is *not* a subclass of Repository<Exception>, but rather Repository<Quibble>.
		 * If it helps, you can think of fully specified types as "subclasses" of
		 * generic types: Foo<T> <- Foo<String>, where every Foo<String> is a Foo,
		 * but not every Foo is a Foo<String> - it's not like that but close enough.
		 * Also, if it helps, you can think of generic classes as "templates" from
		 * which specified classes are made - Foo<T> is a template which makes
		 * specialised classes Foo<String>, Foo<Quibble>, etc. - it's also not
		 * like that but close-ish.
		 */
		Repository<Exception> errors = quibbles;
		
		/*
		 * Finally, looking up quibbles by zimpkin. This works as you'd expect.
		 */
		myQuibbles = quibbles.findByZimpkin("booyah");
	}

}
