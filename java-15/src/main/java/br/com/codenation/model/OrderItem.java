package br.com.codenation.model;

import java.util.Optional;
import java.util.function.Function;

public class OrderItem {

	private Long productId;
	private Long quantity;
	
	public OrderItem(Long productId, Long quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Optional<Double> calculateValue(Function<Long, Optional<Product>> getProduct, final Double desconto) {
		return getProduct.apply(this.getProductId()).map(product ->  {
			final Double valor = product.getValue()*getQuantity();
			if(product.getIsSale()) {
				return valor - valor*desconto;
			}
			return valor;
		});
	}

}
