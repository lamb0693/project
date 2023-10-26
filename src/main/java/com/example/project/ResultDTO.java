package com.example.project;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO {
    String result;

    public ResultDTO(String result){
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "name='" + result + '\'' +
                '}';
    }
}
