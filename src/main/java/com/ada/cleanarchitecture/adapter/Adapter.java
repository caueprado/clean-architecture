package com.ada.cleanarchitecture.adapter;

public interface Adapter<M, D> {
    M adapt(D input);
}
