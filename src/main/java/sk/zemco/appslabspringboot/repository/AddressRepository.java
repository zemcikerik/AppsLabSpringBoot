package sk.zemco.appslabspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import sk.zemco.appslabspringboot.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
