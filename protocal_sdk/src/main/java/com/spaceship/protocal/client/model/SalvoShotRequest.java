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
 * SalvoShotRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-18T22:37:13.441Z")
public class SalvoShotRequest {
  @SerializedName("salvo")
  private List<String> salvo = new ArrayList<String>();

  public SalvoShotRequest salvo(List<String> salvo) {
    this.salvo = salvo;
    return this;
  }

  public SalvoShotRequest addSalvoItem(String salvoItem) {
    this.salvo.add(salvoItem);
    return this;
  }

   /**
   * Get salvo
   * @return salvo
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<String> getSalvo() {
    return salvo;
  }

  public void setSalvo(List<String> salvo) {
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
    SalvoShotRequest salvoShotRequest = (SalvoShotRequest) o;
    return Objects.equals(this.salvo, salvoShotRequest.salvo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(salvo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SalvoShotRequest {\n");

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
