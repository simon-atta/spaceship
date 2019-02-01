package com.spaceship.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spaceship.model.constants.SpaceShipStatus;

/**
 * Game Entity.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "spaceship")
public class Spaceship {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spaceship_id")
	private Long spaceshipId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "spaceship_status")
	private SpaceShipStatus spaceshipStatus;

	@Column(name = "spaceship_address")
	private String spaceshipAddress;

	public String getSpaceshipAddress() {
		return spaceshipAddress;
	}

	public void setSpaceshipAddress(String spaceshipAddress) {
		this.spaceshipAddress = spaceshipAddress;
	}

	/**
	 * @return the spaceshipId
	 */
	public Long getSpaceshipId() {
		return spaceshipId;
	}

	/**
	 * @param spaceshipId
	 *            the spaceshipId to set
	 */
	public void setSpaceshipId(Long spaceshipId) {
		this.spaceshipId = spaceshipId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the spaceshipStatus
	 */
	public SpaceShipStatus getSpaceshipStatus() {
		return spaceshipStatus;
	}

	/**
	 * @param spaceshipStatus
	 *            the spaceshipStatus to set
	 */
	public void setSpaceshipStatus(SpaceShipStatus spaceshipStatus) {
		this.spaceshipStatus = spaceshipStatus;
	}

}
