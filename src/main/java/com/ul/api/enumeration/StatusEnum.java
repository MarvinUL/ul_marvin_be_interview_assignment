package com.ul.api.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusEnum {
	@JsonProperty("IN_PROGRESS")
	IN_PROGRESS,
	@JsonProperty("FINISHED")
	FINISHED

}
