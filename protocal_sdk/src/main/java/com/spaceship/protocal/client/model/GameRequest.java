/*
 * Spaceship Protocal API
 * Spaceship Protocal API help for commincate between spaceships
 *
 * OpenAPI spec version: 1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.spaceship.protocal.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * PGameRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-18T22:37:13.441Z")
public class GameRequest {
  @SerializedName("players")
  private List<GamePlayer> players = new ArrayList<GamePlayer>();

  public GameRequest players(List<GamePlayer> players) {
    this.players = players;
    return this;
  }

  public GameRequest addPlayersItem(GamePlayer playersItem) {
    this.players.add(playersItem);
    return this;
  }

   /**
   * Get players
   * @return players
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<GamePlayer> getPlayers() {
    return players;
  }

  public void setPlayers(List<GamePlayer> players) {
    this.players = players;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameRequest pGameRequest = (GameRequest) o;
    return Objects.equals(this.players, pGameRequest.players);
  }

  @Override
  public int hashCode() {
    return Objects.hash(players);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PGameRequest {\n");

    sb.append("    players: ").append(toIndentedString(players)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
