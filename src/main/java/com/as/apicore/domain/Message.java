package com.as.apicore.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

	@JsonProperty("code")
	private String code;

	@JsonProperty("defaultMessage")
	private String defaultMessage;

	// Lombok will generate getters, setters, equals, hashCode, and toString automatically.
}
