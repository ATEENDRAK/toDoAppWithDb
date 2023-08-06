package com.scaler.toDoAppWithDb.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    @NonNull
    String message;
}
