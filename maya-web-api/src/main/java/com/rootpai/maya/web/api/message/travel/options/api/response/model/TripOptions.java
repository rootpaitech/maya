package com.rootpai.maya.web.api.message.travel.options.api.response.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TripOptions {

  @JsonProperty("slice")
  private List<OptionsSlice> slice;

  public TripOptions() {

    this.slice = new ArrayList<>();
  }

  public boolean getSlice(String origin) {

    Optional<OptionsSlice> optionalOptionsSlice = slice.stream().filter(Objects::nonNull)
        .filter(optionSlice -> optionSlice.getSegment(origin)).findFirst();
    return optionalOptionsSlice.isPresent() ? Boolean.TRUE : Boolean.FALSE;
  }

  /**
   * @return the slice
   */
  public List<OptionsSlice> getSlice() {

    return slice;
  }

  /**
   * @param slice the slice to set
   */
  public void setSlice(List<OptionsSlice> slice) {

    this.slice = slice;
  }
}