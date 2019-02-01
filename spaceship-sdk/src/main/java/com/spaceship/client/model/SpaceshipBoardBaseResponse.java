/*
 * Spaceship API
 * Spaceship API help for commincate between spaceships
 *
 * OpenAPI spec version: 1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.spaceship.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * SpaceshipBoardBaseResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-18T19:52:26.338Z")
public class SpaceshipBoardBaseResponse {
    @SerializedName("board")
    private List<List<String>> board = new ArrayList<List<String>>();

    public SpaceshipBoardBaseResponse board(List<List<String>> board) {
        this.board = board;
        return this;
    }

    public SpaceshipBoardBaseResponse addBoardItem(List<String> boardItem) {
        this.board.add(boardItem);
        return this;
    }

    /**
     * Get board
     *
     * @return board
     **/
    @ApiModelProperty(example = "null", value = "")
    public List<List<String>> getBoard() {
        return board;
    }

    public void setBoard(List<List<String>> board) {
        this.board = board;
    }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpaceshipBoardBaseResponse spaceshipBoardBaseResponse = (SpaceshipBoardBaseResponse) o;
    return Objects.equals(this.board, spaceshipBoardBaseResponse.board);
  }

  @Override
  public int hashCode() {
    return Objects.hash(board);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpaceshipBoardBaseResponse {\n");

    sb.append("    board: ").append(toIndentedString(board)).append("\n");
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

