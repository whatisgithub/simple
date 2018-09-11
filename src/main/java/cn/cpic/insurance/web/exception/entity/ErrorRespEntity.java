package cn.cpic.insurance.web.exception.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorRespEntity {
    private String code;
    private String message;

    public ErrorRespEntity(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
