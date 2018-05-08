package io.swagger.client.model;

import java.util.UUID;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class CollectTokenResponse  {
  
  @SerializedName("FursuitBadgeId")
  private UUID fursuitBadgeId = null;
  @SerializedName("FursuitCollectionCount")
  private Integer fursuitCollectionCount = null;
  @SerializedName("Name")
  private String name = null;
  @SerializedName("Species")
  private String species = null;
  @SerializedName("Gender")
  private String gender = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public UUID getFursuitBadgeId() {
    return fursuitBadgeId;
  }
  public void setFursuitBadgeId(UUID fursuitBadgeId) {
    this.fursuitBadgeId = fursuitBadgeId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getFursuitCollectionCount() {
    return fursuitCollectionCount;
  }
  public void setFursuitCollectionCount(Integer fursuitCollectionCount) {
    this.fursuitCollectionCount = fursuitCollectionCount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getSpecies() {
    return species;
  }
  public void setSpecies(String species) {
    this.species = species;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollectTokenResponse collectTokenResponse = (CollectTokenResponse) o;
    return (fursuitBadgeId == null ? collectTokenResponse.fursuitBadgeId == null : fursuitBadgeId.equals(collectTokenResponse.fursuitBadgeId)) &&
        (fursuitCollectionCount == null ? collectTokenResponse.fursuitCollectionCount == null : fursuitCollectionCount.equals(collectTokenResponse.fursuitCollectionCount)) &&
        (name == null ? collectTokenResponse.name == null : name.equals(collectTokenResponse.name)) &&
        (species == null ? collectTokenResponse.species == null : species.equals(collectTokenResponse.species)) &&
        (gender == null ? collectTokenResponse.gender == null : gender.equals(collectTokenResponse.gender));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (fursuitBadgeId == null ? 0: fursuitBadgeId.hashCode());
    result = 31 * result + (fursuitCollectionCount == null ? 0: fursuitCollectionCount.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (species == null ? 0: species.hashCode());
    result = 31 * result + (gender == null ? 0: gender.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectTokenResponse {\n");
    
    sb.append("  fursuitBadgeId: ").append(fursuitBadgeId).append("\n");
    sb.append("  fursuitCollectionCount: ").append(fursuitCollectionCount).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  species: ").append(species).append("\n");
    sb.append("  gender: ").append(gender).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
