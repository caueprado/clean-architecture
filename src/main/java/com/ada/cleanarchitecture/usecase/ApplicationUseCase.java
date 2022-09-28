package com.ada.cleanarchitecture.usecase;

import com.ada.cleanarchitecture.annotations.UseCase;

@UseCase
@FunctionalInterface
public interface ApplicationUseCase<T, R> {
    R execute(T input);
}
