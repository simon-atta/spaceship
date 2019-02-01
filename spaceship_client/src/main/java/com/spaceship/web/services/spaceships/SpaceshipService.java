package com.spaceship.web.services.spaceships;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spaceship.client.ApiException;
import com.spaceship.client.api.SpaceshipsresourceApi;
import com.spaceship.client.api.XlspaceshipresourceApi;
import com.spaceship.client.model.InlineResponse200;
import com.spaceship.client.model.InlineResponse2001;
import com.spaceship.client.model.InlineResponse2003;
import com.spaceship.client.model.SpaceshipRequest;
import com.spaceship.client.model.XLSpaceshipRequest;
import com.spaceship.web.model.spaceship.SpaceshipBoard;
import com.spaceship.web.model.spaceship.SpaceshipShape;

@Service
public class SpaceshipService implements ISpaceshipService {

    @Override
    public List<InlineResponse2001> getSpaceshipsByUserName(String userName) throws ApiException {
        XlspaceshipresourceApi xlSpaceshipresourceApi = new XlspaceshipresourceApi();
        return xlSpaceshipresourceApi.getSpaceshipsByUserIdUsingGET(userName);
    }

    @Override
    public InlineResponse2001 getSpaceshipById(Long spaceshipId) throws ApiException {
        XlspaceshipresourceApi xlSpaceshipresourceApi = new XlspaceshipresourceApi();
        return xlSpaceshipresourceApi.getSpaceshipByidUsingGET(spaceshipId);
    }

    @Override
    public List<InlineResponse2001> getAllSpaceships() throws ApiException {
        XlspaceshipresourceApi xlSpaceshipresourceApi = new XlspaceshipresourceApi();
        return xlSpaceshipresourceApi.getSpaceshipsListUsingGET();
    }

    @Override
    public void assignXLSpaceshipToUser(String spaceshipId, String userId) throws ApiException {
        XlspaceshipresourceApi xlSpaceshipresourceApi = new XlspaceshipresourceApi();
        XLSpaceshipRequest xLSpaceshipRequest = new XLSpaceshipRequest();
        xLSpaceshipRequest.setSpaceShipId(Long.parseLong(spaceshipId));
        xLSpaceshipRequest.userId(userId);
        xlSpaceshipresourceApi.initializeSpaceshipUsingPOST(xLSpaceshipRequest);
    }

    @Override
    public void addSpaceship(SpaceshipRequest spaceshipRequest, Long spaceshipId) throws ApiException {
        XlspaceshipresourceApi xlSpaceShipreSourceApi = new XlspaceshipresourceApi();
        SpaceshipsresourceApi spaceShipreSourceApi = new SpaceshipsresourceApi();
        InlineResponse2001 xlSpaceship = xlSpaceShipreSourceApi.getSpaceshipByidUsingGET(spaceshipId);
        spaceShipreSourceApi.getApiClient().setBasePath(getXLSpaceURL(xlSpaceship.getSpaceshipAddress()));
        spaceShipreSourceApi.placeSpaceshipUsingPOST(spaceshipRequest);
    }

    @Override
    public SpaceshipBoard getSpaceships(Long spaceshipId) throws ApiException {

        XlspaceshipresourceApi spaceShipreSourceApi = new XlspaceshipresourceApi();
        InlineResponse2001 xlSpaceship = spaceShipreSourceApi.getSpaceshipByidUsingGET(spaceshipId);
        spaceShipreSourceApi.getApiClient().setBasePath(getXLSpaceURL(xlSpaceship.getSpaceshipAddress()));
        InlineResponse200 spaceshipResponse = spaceShipreSourceApi.getSpaceShipBoardUsingGET();

        SpaceshipBoard spaceshipBoard = new SpaceshipBoard();
        spaceshipBoard.setBoard(spaceshipResponse.getBoard());
        spaceshipBoard.setSpaceshipsType(spaceshipResponse.getSpaceships());

        return spaceshipBoard;
    }

    private String[][] getBoardAsArray(String boardStr) {
        String[] rows = boardStr.split(",");
        String[][] board = new String[rows.length][];

        int rowCount = 0;
        for (String row : rows) {
            board[rowCount++] = row.split("");
        }
        return board;
    }

    private String getXLSpaceURL(String spaceShipAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(spaceShipAddress);
        return stringBuilder.toString();
    }

    @Override
    public List<SpaceshipShape> getSpaceshipsShape(Long spaceshipId) throws ApiException {
        SpaceshipsresourceApi spaceShipreSourceApi = new SpaceshipsresourceApi();
        XlspaceshipresourceApi xlSpaceShipreSourceApi = new XlspaceshipresourceApi();
        InlineResponse2001 xlSpaceship = xlSpaceShipreSourceApi.getSpaceshipByidUsingGET(spaceshipId);
        spaceShipreSourceApi.getApiClient().setBasePath(getXLSpaceURL(xlSpaceship.getSpaceshipAddress()));
        List<InlineResponse2003> spaceShipsShapeResp = spaceShipreSourceApi.getSpaceShipsShapesUsingGET();
        List<SpaceshipShape> spaceshipShapes = new ArrayList<>();
        for (InlineResponse2003 resp : spaceShipsShapeResp) {

            String[][] boardArr = getBoardAsArray(resp.getShape());
            getStringArr(boardArr);

            spaceshipShapes.add(new SpaceshipShape(resp.getName(), boardArr, boardArr[0].length, boardArr.length));
        }

        return spaceshipShapes;
    }

    private void getStringArr(String[][] boardArr) {

        for (int i = 0; i < boardArr.length; i++) {
            for (int j = 0; j < boardArr[i].length; j++) {

                if (boardArr[i][j].equals(" ")) {
                    boardArr[i][j] = ".";
                }
            }
        }

    }

}
