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
 * InlineResponse2003
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-18T19:52:26.338Z")
public class InlineResponse2003 {
  @SerializedName("name")
  private String name = null;

  @SerializedName("shape")
  private String shape = null;

  public InlineResponse2003 name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InlineResponse2003 shape(String shape) {
    this.shape = shape;
    return this;
  }

   /**
   * Get shape
   * @return shape
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getShape() {
    return shape;
  }

  public void setShape(String shape) {
    this.shape = shape;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2003 inlineResponse2003 = (InlineResponse2003) o;
    return Objects.equals(this.name, inlineResponse2003.name) &&
        Objects.equals(this.shape, inlineResponse2003.shape);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, shape);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2003 {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    shape: ").append(toIndentedString(shape)).append("\n");
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

