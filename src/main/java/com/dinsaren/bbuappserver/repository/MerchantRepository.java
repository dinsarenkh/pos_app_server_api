package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Merchant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MerchantRepository extends CrudRepository<Merchant, Integer> {
    List<Merchant> findAllByStatus(String status);
    List<Merchant> findAllByHolderIdAndStatus(Integer userId, String status);
    Optional<Merchant> findByIdAndStatus(Integer id, String status);
}
