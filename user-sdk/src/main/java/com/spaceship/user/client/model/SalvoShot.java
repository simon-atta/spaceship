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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * SalvoShot
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-19T16:17:59.908Z")
public class SalvoShot {
  @SerializedName("salvo")
  private List<String> salvo = new ArrayList<String>();

  public SalvoShot salvo(List<String> salvo) {
    this.salvo = salvo;
    return this;
  }

  public SalvoShot addSalvoItem(String salvoItem) {
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
    SalvoShot salvoShot = (SalvoShot) o;
    return Objects.equals(this.salvo, salvoShot.salvo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(salvo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SalvoShot {\n");

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

