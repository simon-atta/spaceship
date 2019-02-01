package com.spaceship.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.spaceship.model.SpaceshipConf;
import com.spaceship.model.constants.SpaceShipStatus;
import com.spaceship.model.entities.Spaceship;
import com.spaceship.repositories.SpaceshipRepo;

@Component
public class SpaceshipManagement implements ISpaceshipManagement {

    @Autowired
    private SpaceshipRepo spaceshipRepo;

    @Autowired
    private Environment environment;

    @Autowired
    private SpaceshipConf spaceshipConf;

    @Override
    public void addSpaceshipAddress() {
        StringBuilder address = new StringBuilder();
        address.append("http://");
        address.append(spaceshipConf.getHostname());
        address.append(":");
        address.append(environment.getProperty("local.server.port"));

        Spaceship spaceship = new Spaceship();
        spaceship.setSpaceshipAddress(address.toString());
        spaceship.setSpaceshipStatus(SpaceShipStatus.ACTIVE);
        spaceshipRepo.save(spaceship);
    }

    @Override
    public void shutDown() {

    }

}
