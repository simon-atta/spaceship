package com.spaceship.model.vo.board;

public class SpaceshipBoardRequest {

	private String spaceShipName;
	private Integer xCoordinate;
	private Integer yCoordinate;


	public String getSpaceShipName() {
		return spaceShipName;
	}

	public void setSpaceShipName(String spaceShipName) {
		this.spaceShipName = spaceShipName;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

}
