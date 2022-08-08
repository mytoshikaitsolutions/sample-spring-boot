package com.alpha.rest.controller;

import javax.validation.constraints.NotNull;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.constants.SuccessAlphaApiMessage;
import com.alpha.dto.ResponseDto;
import com.alpha.response.BaseResponse;
import com.alpha.response.PageBaseResponse;
import com.alpha.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Product Controller Provider")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	private ProductService productService;
	
	@Operation(summary  = "API to delete product by productId")
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<BaseResponse<ResponseDto, String>> deleteProduct(
			@PathVariable(value ="productId") String productId) {
		
		productService.deleteProduct(productId);
        BaseResponse<ResponseDto, String> response = new BaseResponse<ResponseDto, String>();
        response.setData(null);
        response.setMessage(SuccessAlphaApiMessage.OK_PRODUCT_DELETED);
        return ResponseEntity.ok().body(response);
	}

	@Operation(summary  = "API to get a list of all products")
	@GetMapping("/products")
	@PageableAsQueryParam
	public ResponseEntity<PageBaseResponse<ResponseDto, String>> getProducts(
	        @PageableDefault(page = 0, size = 20000)
            @SortDefault.SortDefaults({
                @SortDefault(sort = "createdOn", direction = Sort.Direction.DESC),
            })
	        @Parameter(hidden = true) @NotNull final Pageable pageable,
            @RequestParam(name = "deleted", defaultValue = "false") boolean deleted) {
		
		Page<ResponseDto> page = productService.getProducts(deleted, pageable);
		PageBaseResponse<ResponseDto, String> response = new PageBaseResponse<ResponseDto, String>();
		response.setDataList(page.getContent());
		response.setMessage(SuccessAlphaApiMessage.OK_PRODUCT_GET_ALL);
		response.setTotalPages(page.getTotalPages());
		response.setTotalElements(page.getTotalElements());
		response.setSize(page.getSize());
		response.setNumber(page.getNumber());
		return ResponseEntity.ok().body(response);
	}
}

