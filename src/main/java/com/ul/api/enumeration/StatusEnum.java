package com.ul.api.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author neelabh
 * @apiNote Enum created with given values
 *
 */
public enum StatusEnum {
	@JsonProperty("IN_PROGRESS")
	IN_PROGRESS,
	@JsonProperty("FINISHED")
	FINISHED

}
