package com.spaceship.web.model.constacts;

public enum ViewConstants {

    EXCEPTION_MESSAGE("Something went wrong!"),
    XLSPACESHIP_LIST_ALL("spaceship/xlspaceship_list"),
    XLSPACESHIP_USER_LIST("spaceship/xlspaceship_user_list"),
    XLSPACESHIP_ASSIGN("spaceship/xlspaceship_assign"),
    SPACEBOARD("spaceship/spaceship_board"),
    ERROR_CODE("spaceship"),
    ERROR("error"),
    SPACESHIPS_PARAM("spaceships"),
    USER_PARAM("user"),
    SPACESHIP_ID("spaceshipId"),
    SPACESHIP_REQUEST("spaceshipReq"),
    SPACESHIP_SHAPES("spaceShipShapes"),
    SPACESHIP_BOARD("spaceShipBoard"),
    SPACESHIP_BOARD_ARRAY("spaceShipBoardArr"),
    GAME_LIST_REDIRECT("redirect:/listgames"),
    GAME_LIST("gameList"),
    GAME_ID("gameId"),
    GAME_STATUS("gameStatus"),
    GAME_AUTO_STATUS("gameAutoStatus"),
    GAME_STATUS_SELF("gameBoardSelf"),
    GAME_STATUS_OPP("gameBoardOpp"),
    GAME_FIRE("fireCount"),
    GAME_FIRE_RESULTS("fireResults"),
    GAME_SALVOSHOTS("salvoShots"),
    GAME_LIST_VIEW("game/game_list"),
    GAME_STATUS_VIEW("game/game_status"),
    GAME_FIRE_VIEW("game/game_fire"),
    GAME_FIRE_RESULTS_VIEW("game/game_fire_results");
    private String constant;

    private ViewConstants(String constant) {
        this.constant = constant;
    }

    /**
     * @return the constant
     */
    public String getConstant() {
        return constant;
    }


    @Override
    public String toString() {
        return constant;
    }


}
