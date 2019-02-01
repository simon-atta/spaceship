package com.spaceship.model.vo.ship;

public class XLSpaceshipRequest {

	private Long spaceShipId;
	private String userId;

	public XLSpaceshipRequest() {
		super();
	}

	public XLSpaceshipRequest(Long spaceShipId, String userId) {
		super();
		this.spaceShipId = spaceShipId;
		this.userId = userId;
	}

	public XLSpaceshipRequest(String userId) {
		super();
		this.userId = userId;
	}

	public Long getSpaceShipId() {
		return spaceShipId;
	}

	public void setSpaceShipId(Long spaceShipId) {
		this.spaceShipId = spaceShipId;
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

}
