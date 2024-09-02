package ra.ecommerceapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.ecommerceapi.model.dto.response.ProductUserDTO;
import ra.ecommerceapi.model.entity.Product;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Long> {
    @Query("select p.image from Product p where p.id= :id")
    String getImgById(@Param("id") Long id);

    Boolean existsByName(String name);

//    void findTop5ByC

    Page<Product> findAllByNameContains(String name, Pageable pageable);

    Page<Product> findAllByNameContainsOrDescriptionContainsAndStatusTrue(String name,String description,Pageable pageable);

    Page<Product> findAllByCategoryId(Long id,Pageable pageable);

}
