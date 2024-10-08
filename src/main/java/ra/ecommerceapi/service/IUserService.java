package ra.ecommerceapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.ecommerceapi.exception.CustomException;
import ra.ecommerceapi.model.dto.request.UserRequest;
import ra.ecommerceapi.model.dto.response.UserResponse;
import ra.ecommerceapi.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Page<User> findAllPaginationAdmin(String search,Pageable pageable);

    void addRoleForUser(Long userId,Long roleId) throws CustomException;

    void deleteRoleForUser(Long userId,Long roleId) throws CustomException;

    User findUserExceptAdminById(Long id);

    User save(User user);

    UserResponse save(UserRequest userRequest);

    User findByEmail(String email);

    Boolean existsByEmail(String email);

    void toggleStatus(Long id);

    UserResponse findById();

    User findById(Long id);



}
