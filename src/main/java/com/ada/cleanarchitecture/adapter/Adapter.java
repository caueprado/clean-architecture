package com.ada.cleanarchitecture.adapter;

public interface Adapter<T, R> {
    R adapt(T input);
}
