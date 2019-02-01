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

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * SalvoShotResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-18T19:52:26.338Z")
public class SalvoShotResponse {
  @SerializedName("bullet")
  private String bullet = null;

  @SerializedName("result")
  private String result = null;

  public SalvoShotResponse bullet(String bullet) {
    this.bullet = bullet;
    return this;
  }

   /**
   * Get bullet
   * @return bullet
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBullet() {
    return bullet;
  }

  public void setBullet(String bullet) {
    this.bullet = bullet;
  }

  public SalvoShotResponse result(String result) {
    this.result = result;
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SalvoShotResponse salvoShotResponse = (SalvoShotResponse) o;
    return Objects.equals(this.bullet, salvoShotResponse.bullet) &&
        Objects.equals(this.result, salvoShotResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bullet, result);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SalvoShotResponse {\n");

    sb.append("    bullet: ").append(toIndentedString(bullet)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

