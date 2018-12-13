package com.models;

public interface RequestListener <T>
{
    void onComplete(T t);
    void onError(String errorMsg);

}
