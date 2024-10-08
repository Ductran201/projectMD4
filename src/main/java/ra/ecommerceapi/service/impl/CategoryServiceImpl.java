package ra.ecommerceapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ra.ecommerceapi.exception.CustomException;
import ra.ecommerceapi.model.entity.Category;
import ra.ecommerceapi.repository.ICategoryRepo;
import ra.ecommerceapi.service.ICategoryService;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Page<Category> findAllPaginationAdmin(String search, Pageable pageable) {
        return categoryRepo.findAllByNameContains(search, pageable);
    }

    @Override
    public Page<Category> findAllPaginationUser(String search, Pageable pageable) {
        return categoryRepo.findAllByNameContainsAndStatusTrue(search, pageable);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Not found this category"));
    }


    @Override
    public Category save(Category category) throws CustomException {

        if (categoryRepo.existsByName(category.getName())) {
            throw new CustomException("This category already exist", HttpStatus.CONFLICT);
        }

        category.setStatus(true);
        category.setCreatedDate(new Date());
        return categoryRepo.save(category);
    }

    @Override
    public Category save(Category category, Long id) throws CustomException {
        Category oldCategory = findById(id);

        if (!category.getName().equals(oldCategory.getName()) && categoryRepo.existsByName(category.getName())) {
            throw new CustomException("This category already exist", HttpStatus.CONFLICT);
        }

        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
        return categoryRepo.save(oldCategory);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
