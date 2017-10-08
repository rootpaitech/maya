/**
 * 
 */
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
public class OptionsSlice {

  @JsonProperty("segment")
  private List<Segment> segments;

  public OptionsSlice() {

    this.segments = new ArrayList<>();
  }

  public boolean getSegment(String origin) {

    Optional<Segment> optionalSegment = segments.stream().filter(Objects::nonNull)
        .filter(segment -> segment.getLeg(origin)).findFirst();
    return optionalSegment.isPresent() ? Boolean.TRUE : Boolean.FALSE;
  }

  /**
   * @return the segments
   */
  public List<Segment> getSegments() {

    return segments;
  }

  /**
   * @param segments the segments to set
   */
  public void setSegments(List<Segment> segments) {

    this.segments = segments;
  }
}