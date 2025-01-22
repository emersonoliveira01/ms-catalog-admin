package com.stream.catalog.admin.application.category.retrieve.list;

import com.stream.catalog.admin.application.UseCase;
import com.stream.catalog.admin.domain.category.CategorySearchQuery;
import com.stream.catalog.admin.domain.pagination.Pagination;

public abstract class ListCategoriesUseCase extends UseCase<CategorySearchQuery, Pagination<CategoryListOutput>> {
}
