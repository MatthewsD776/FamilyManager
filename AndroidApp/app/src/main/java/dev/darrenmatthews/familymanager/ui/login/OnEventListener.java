package dev.darrenmatthews.familymanager.ui.login;

public interface OnEventListener<T> {
    void onSuccess(T object);
    void onFailure(Exception e);
}
