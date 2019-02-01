/*
 * User Protocal API
 * User Protocal API help for commincate between users
 *
 * OpenAPI spec version: 1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.spaceship.user.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;

/**
 * InlineResponse200
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-19T16:17:59.908Z")
public class FireSalvoShots {
  @SerializedName("game")
  private Map<String, String> game = new HashMap<String, String>();

  @SerializedName("salvo")
  private Map<String, String> salvo = new HashMap<String, String>();

  public FireSalvoShots game(Map<String, String> game) {
    this.game = game;
    return this;
  }

  public FireSalvoShots putGameItem(String key, String gameItem) {
    this.game.put(key, gameItem);
    return this;
  }

   /**
   * Get game
   * @return game
  **/
  @ApiModelProperty(example = "null", value = "")
  public Map<String, String> getGame() {
    return game;
  }

  public void setGame(Map<String, String> game) {
    this.game = game;
  }

  public FireSalvoShots salvo(Map<String, String> salvo) {
    this.salvo = salvo;
    return this;
  }

  public FireSalvoShots putSalvoItem(String key, String salvoItem) {
    this.salvo.put(key, salvoItem);
    return this;
  }

   /**
   * Get salvo
   * @return salvo
  **/
  @ApiModelProperty(example = "null", value = "")
  public Map<String, String> getSalvo() {
    return salvo;
  }

  public void setSalvo(Map<String, String> salvo) {
    this.salvo = salvo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FireSalvoShots inlineResponse200 = (FireSalvoShots) o;
    return Objects.equals(this.game, inlineResponse200.game) &&
        Objects.equals(this.salvo, inlineResponse200.salvo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(game, salvo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");

    sb.append("    game: ").append(toIndentedString(game)).append("\n");
    sb.append("    salvo: ").append(toIndentedString(salvo)).append("\n");
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
