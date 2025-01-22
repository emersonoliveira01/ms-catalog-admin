package com.stream.catalog.admin.infrastructure.configuration.category.persistence;

import com.stream.catalog.admin.domain.category.Category;
import com.stream.catalog.admin.infrastructure.MySQLGatewayTest;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

@MySQLGatewayTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void givenAValidNullNameCategory_whenCallsSave_shouldReturnError() {

        final var expectedName = "Filmes";
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;

        final var category = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var categoryJpaEntity = CategoryJpaEntity.from(category);
        categoryJpaEntity.setName(null);

        final var actualException =
                Assertions.assertThrows(DataIntegrityViolationException.class, () -> categoryRepository.save(categoryJpaEntity));

        Assertions.assertInstanceOf(PropertyValueException.class, actualException.getCause());

    }

    @Test
    public void givenAValidNullCreatedAtCategory_whenCallsSave_shouldReturnError() {

        final var expectedName = "Filmes";
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;

        final var category = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var categoryJpaEntity = CategoryJpaEntity.from(category);
        categoryJpaEntity.setCreatedAt(null);

        final var actualException =
                Assertions.assertThrows(DataIntegrityViolationException.class, () -> categoryRepository.save(categoryJpaEntity));

        Assertions.assertInstanceOf(PropertyValueException.class, actualException.getCause());

    }

    @Test
    public void givenAValidNullUpdatedAtCategory_whenCallsSave_shouldReturnError() {

        final var expectedName = "Filmes";
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;

        final var category = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var categoryJpaEntity = CategoryJpaEntity.from(category);
        categoryJpaEntity.setUpdatedAt(null);

        final var actualException =
                Assertions.assertThrows(DataIntegrityViolationException.class, () -> categoryRepository.save(categoryJpaEntity));

        Assertions.assertInstanceOf(PropertyValueException.class, actualException.getCause());

    }
}
