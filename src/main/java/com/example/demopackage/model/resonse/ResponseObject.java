package com.example.demopackage.model.resonse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseObject<T> {
    private T data;

    public ResponseObject(T data) {
        this.data = data;
    }

}

