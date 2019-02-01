package com.spaceship.user.services;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spaceship.protocal.client.api.GameresourceApi;
import com.spaceship.protocal.client.model.InlineResponse2002;
import com.spaceship.user.exception.IntegrationException;
import com.spaceship.user.model.vo.SalvoShotRequest;
import com.spaceship.user.model.vo.SalvoShotResponse;

@Service
public class GameService implements IGameService {

    private static final Logger LOGGER = Logger.getLogger(GameService.class);

    /**
     * @see com.spaceship.user.services.IGameService#fireSalvoShots(SalvoShotRequest, String)
     */
    @Override
    public SalvoShotResponse fireSalvoShots(SalvoShotRequest salvoShot, String gameId) throws IntegrationException {
        try {

            // Validate number of salvo shots


            // Call protocal api
            GameresourceApi gameresourceApi = new GameresourceApi();
            com.spaceship.protocal.client.model.SalvoShot salvoShotRequest = new com.spaceship.protocal.client.model.SalvoShot();
            salvoShotRequest.setSalvo(salvoShot.getSalvo());
            InlineResponse2002 response = gameresourceApi.receiveFireUsingPUT(salvoShotRequest, gameId);

            SalvoShotResponse salvoShotResponse = new SalvoShotResponse();
            salvoShotResponse.setGame(response.getGame());
            salvoShotResponse.setSalvo(response.getSalvo());

            return salvoShotResponse;

        } catch (com.spaceship.protocal.client.ProtocalApiException e) {
            LOGGER.error(e);
            throw new IntegrationException(HttpStatus.valueOf(e.getCode()));
        }
    }


}
