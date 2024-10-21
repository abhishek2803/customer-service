package com.thehutgroup.apicoresdk.domain;

import com.as.apicore.domain.Message;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)  // Only include non-null fields in the JSON response.
public class Response {

	@JsonProperty("timestamp")
	private Date timestamp;

	@JsonProperty("status")
	private Integer status;

	@JsonProperty("error")
	private String error;

	@JsonProperty("errors")
	@Singular  // Lombok will allow setting the 'errors' field using a builder pattern with multiple entries.
	private List<Message> errors;

	@JsonProperty("message")
	private String message;

	@JsonProperty("messages")
	@Singular("messageItem")  // Lombok will generate a builder method allowing to add individual items.
	private List<Message> messages;

	@JsonProperty("path")
	private String path;

	@JsonProperty("data")
	private Object data;

	public static ResponseBuilder builder(HttpStatus httpStatus) {
		return new ResponseBuilder()
				.timestamp(new Date())  // Automatically set timestamp.
				.status(httpStatus != null ? httpStatus.value() : null)  // Set status based on HttpStatus.
				.error(httpStatus != null && httpStatus.isError() ? httpStatus.getReasonPhrase() : null);  // Set error if applicable.
	}
}
