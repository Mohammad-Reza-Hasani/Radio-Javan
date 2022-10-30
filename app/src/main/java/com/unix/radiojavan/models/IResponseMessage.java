package com.unix.radiojavan.models;

public interface IResponseMessage<T> {


    void onResponse(T responseMessage);


    void onFailure(String errorResponseMassage);


}
