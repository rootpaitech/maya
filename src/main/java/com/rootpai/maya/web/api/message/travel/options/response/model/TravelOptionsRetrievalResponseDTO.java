package com.rootpai.maya.web.api.message.travel.options.response.model;

import java.util.List;

import com.rootpai.maya.web.api.message.travel.options.api.response.model.HotelOptionsAPIResponse;

/**
 * @author agara
 *
 */
public class TravelOptionsRetrievalResponseDTO {

  private List<TripRetrievedOtions> onwardTripOptions;

  private List<TripRetrievedOtions> returnTripOptions;

  private HotelOptionsAPIResponse hotelOptionsAPIResponse;

  /**
   * @param onwardTripOptions
   * @param returnTripOptions
   */
  public TravelOptionsRetrievalResponseDTO(List<TripRetrievedOtions> onwardTripOptions,
      List<TripRetrievedOtions> returnTripOptions) {

    this.onwardTripOptions = onwardTripOptions;
    this.returnTripOptions = returnTripOptions;
  }

  /**
   * @return the onwardTripOptions
   */
  public List<TripRetrievedOtions> getOnwardTripOptions() {

    return onwardTripOptions;
  }

  /**
   * @return the returnTripOptions
   */
  public List<TripRetrievedOtions> getReturnTripOptions() {

    return returnTripOptions;
  }

  /**
   * @return the hotelOptionsAPIResponse
   */
  public HotelOptionsAPIResponse getHotelOptionsAPIResponse() {

    return hotelOptionsAPIResponse;
  }

  /**
   * @param hotelOptionsAPIResponse the hotelOptionsAPIResponse to set
   */
  public void setHotelOptionsAPIResponse(
      HotelOptionsAPIResponse hotelOptionsAPIResponse) {

    this.hotelOptionsAPIResponse = hotelOptionsAPIResponse;
  }
}