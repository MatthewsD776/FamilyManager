package dev.darrenmatthews.familymanager.app.async;

public interface OnEventListener<T> {
    void onSuccess(T object);
    void onFailure(Exception e);
}
