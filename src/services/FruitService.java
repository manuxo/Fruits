package services;

import java.util.List;

import models.FruitRepository;
import models.IFruitRepository;
import models.entities.Fruit;

public class FruitService implements IFruitService {

	private IFruitRepository fruitRepo = null;
	
	public FruitService() {
		this.fruitRepo = new FruitRepository();
	}
	
	@Override
	public List<Fruit> findAll() {
		return this.fruitRepo.findAll();
	}

	@Override
	public Fruit findById(Integer id) {
		return this.fruitRepo.findById(id);
	}

	@Override
	public int save(Fruit entity) {
		return this.fruitRepo.save(entity);
	}

	@Override
	public int update(Fruit entity) {
		return this.fruitRepo.update(entity);
	}

	@Override
	public int delete(Integer id) {
		return this.fruitRepo.delete(id);
	}

}
