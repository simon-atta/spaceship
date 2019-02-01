package com.spaceship.user.services;

import com.spaceship.user.exception.IntegrationException;
import com.spaceship.user.model.vo.SalvoShotRequest;
import com.spaceship.user.model.vo.SalvoShotResponse;

public interface IGameService {

    /**
     * This method will be used to fire salvo shots for opponent.
     * <p>
     * Will be validation before fire salvo shots for how many salvo shot user
     * can fire.
     * <p>
     * this will be done do rest call to protocal to check how many
     * bullets player can fire.
     *
     * @param salvoShot
     *        SalvoShotRequest
     * @param gameId
     *        String
     * @return salvo shot response object which have map of salvo shots results
     *         and player turn.
     * @throws IntegrationException
     *         which http status from ws calls.
     */
    SalvoShotResponse fireSalvoShots(SalvoShotRequest salvoShot, String gameId) throws IntegrationException;
}
