package com.stream.catalog.admin.application;

import com.stream.catalog.admin.domain.category.Category;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN anIn);
}