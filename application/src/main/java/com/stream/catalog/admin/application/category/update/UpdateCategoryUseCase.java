package com.stream.catalog.admin.application.category.update;

import com.stream.catalog.admin.application.UseCase;
import com.stream.catalog.admin.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase
        extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}
