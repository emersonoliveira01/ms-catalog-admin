package com.stream.catalog.admin.application.category.create;

import com.stream.catalog.admin.application.UseCase;
import com.stream.catalog.admin.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase extends
        UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {

}
