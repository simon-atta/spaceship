package com.spaceship.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spaceship.exceptions.XLSpaceshipException;
import com.spaceship.model.entities.Spaceship;
import com.spaceship.model.vo.ship.XLSpaceshipRequest;
import com.spaceship.repositories.SpaceshipRepo;

/**
 * This is concert implementation of
 * {@link com.spaceship.services.ISpaceshipService}
 *
 * @author Simon Ghobreil.
 */
@Service
public class SpaceshipService implements ISpaceshipService {

	@Autowired
	private SpaceshipRepo spaceshipRepo;

	/**
	 * @see com.spaceship.services.ISpaceshipService#assignUserToSpaceship(XLSpaceshipRequest)
	 */
	@Override
	@Transactional
	public void assignUserToSpaceship(XLSpaceshipRequest pSpaceshipRequest) throws XLSpaceshipException {
		Spaceship vSpaceship = spaceshipRepo.findOne(pSpaceshipRequest.getSpaceShipId());

		if (null == vSpaceship.getUserId()) {
			vSpaceship.setUserId(pSpaceshipRequest.getUserId());
			spaceshipRepo.save(vSpaceship);
		} else if (vSpaceship.getUserId().isEmpty()) {
			vSpaceship.setUserId(pSpaceshipRequest.getUserId());
			spaceshipRepo.save(vSpaceship);
		} else {
			throw new XLSpaceshipException(HttpStatus.FORBIDDEN, "Spaceship already assigned!");
		}
	}

	/**
	 * @see com.spaceship.services.ISpaceshipService#getSpaceshipsList()
	 */
	@Override
	public List<Spaceship> getSpaceshipsList() {
		return spaceshipRepo.findAll();
	}

	/**
	 * @see com.spaceship.services.ISpaceshipService#getSpaceshipsByUserId(String)
	 */
	@Override
	public List<Spaceship> getSpaceshipsByUserId(String userId) {
		return spaceshipRepo.findByUserId(userId);
	}

	/**
	 * @see com.spaceship.services.ISpaceshipService#getSpaceshipsById(Long)
	 */
	@Override
	public Spaceship getSpaceshipsById(Long spaceshipId) {
		return spaceshipRepo.findBySpaceshipId(spaceshipId);
	}

}
