package com.alpha.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductDto {
	
	@NotBlank(message = "Product Name must not be empty")
	@Size(max = 255, message = "Product name should have maximum 255 characters")
	@Schema(description = "Name of Product ", example = "Client A")
	private String name;
}
