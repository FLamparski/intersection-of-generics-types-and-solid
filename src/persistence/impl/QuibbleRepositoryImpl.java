package persistence.impl;

import java.util.Collection;

import model.Quibble;
import persistence.QuibbleRepository;

public class QuibbleRepositoryImpl extends RepositoryImpl<Quibble> implements QuibbleRepository {

	public QuibbleRepositoryImpl(String db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Quibble> findByZimpkin(String zimpkin) {
		// TODO Auto-generated method stub
		return null;
	}

}
