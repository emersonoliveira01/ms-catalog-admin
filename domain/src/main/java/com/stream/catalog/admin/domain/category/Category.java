package com.stream.catalog.admin.domain.category;

import com.stream.catalog.admin.domain.AggregateRoot;
import com.stream.catalog.admin.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> implements Cloneable {

    private String name;
    private String description;
    private boolean active;
    private Instant createAt;
    private Instant updateAt;
    private Instant deleteAt;

    private Category(
            final CategoryID anId,
            final String aName,
            final String aDescription,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {
        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createAt = aCreationDate;
        this.updateAt = aUpdateDate;
        this.deleteAt = aDeleteDate;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
        final var id = CategoryID.unique();
        final var now = Instant.now();
        final var deleteAt = isActive ? null : now;
        return new Category(id, aName, aDescription, isActive, now, now, deleteAt);
    }

    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public Category activate() {
        this.deleteAt = null;
        this.active = true;
        this.updateAt = Instant.now();
        return this;
    }

    public Category deactivate() {
        if (getDeleteAt() == null) {
            this.deleteAt = Instant.now();
        }

        this.active = false;
        this.updateAt = Instant.now();
        return this;
    }

    public Category update(
            final String aName,
            final String aDescription,
            final boolean isActive
    ) {
        if (isActive) {
            activate();
        } else {
            deactivate();
        }

        this.name = aName;
        this.description = aDescription;
        this.updateAt = Instant.now();
        return this;

    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Instant getDeleteAt() {
        return deleteAt;
    }

    @Override
    public Category clone() {
        try {
            return (Category) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}