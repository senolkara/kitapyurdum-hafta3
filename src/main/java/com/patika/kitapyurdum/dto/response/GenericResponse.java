package com.patika.kitapyurdum.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.kitapyurdum.constants.KitapYurdumConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {

    private String status;
    private HttpStatus httpStatus;
    private T data;
    private T error;

    public static GenericResponse<ExceptionResponse> failed(String message) {
        return GenericResponse.<ExceptionResponse>builder()
                .status(KitapYurdumConstants.FAILED)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .error(new ExceptionResponse(message))
                .build();
    }

    public static <T> GenericResponse<T> success(T data) {
        return GenericResponse.<T>builder()
                .status(KitapYurdumConstants.SUCCESS)
                .httpStatus(HttpStatus.OK)
                .data(data)
                .build();
    }

}
