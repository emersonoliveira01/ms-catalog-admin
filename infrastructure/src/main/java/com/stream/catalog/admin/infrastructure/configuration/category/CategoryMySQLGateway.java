package com.stream.catalog.admin.infrastructure.configuration.category;

import com.stream.catalog.admin.domain.category.Category;
import com.stream.catalog.admin.domain.category.CategoryGateway;
import com.stream.catalog.admin.domain.category.CategoryID;
import com.stream.catalog.admin.domain.category.CategorySearchQuery;
import com.stream.catalog.admin.domain.pagination.Pagination;
import com.stream.catalog.admin.infrastructure.configuration.category.persistence.CategoryJpaEntity;
import com.stream.catalog.admin.infrastructure.configuration.category.persistence.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryMySQLGateway implements CategoryGateway {

    private final CategoryRepository repository;

    public CategoryMySQLGateway(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(final Category aCategory) {
        return save(aCategory);
    }

    @Override
    public void deleteById(final CategoryID anId) {
        if (this.repository.existsById(anId.getValue())) {
            this.repository.deleteById(anId.getValue());
        }
    }

    @Override
    public Optional<Category> findById(CategoryID anId) {
        return Optional.empty();
    }

    @Override
    public Category update(final Category aCategory) {
        return save(aCategory);
    }

    @Override
    public Pagination<Category> findAll(CategorySearchQuery aQuery) {
        return null;
    }

    private Category save(Category aCategory) {
        return this.repository.save(CategoryJpaEntity.from(aCategory)).toAggregate();
    }
}
