package com.spaceship.protocal.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "spaceship_protocal")
public class SpaceShipProtocal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spaceship_id")
	private Long spaceshipId;

	@Column(name = "host_name")
	private String hostName;

	@Column(name = "port")
	private String port;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "spaceShipProtocal")
	private Player player;

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @param hostName
	 *            the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	public Long getSpaceshipId() {
		return spaceshipId;
	}

	public void setSpaceshipId(Long spaceshipId) {
		this.spaceshipId = spaceshipId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
