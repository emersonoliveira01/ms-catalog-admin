package com.stream.catalog.admin.application;

import com.stream.catalog.admin.domain.category.Category;

public class UseCase {

    public Category execute() {
        return new Category();
    }
}