package acc.microservices.shopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import acc.microservices.shopping.model.pojos.Customer;

@FeignClient(name = "customer-service", fallback = CustomerFallbackConfig.class)
public interface CustomerClient {

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
}
