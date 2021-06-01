package com.wfx.vo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Result<T> {

    @NonNull
    private boolean success;

    @NonNull
    private String msg;

    private T data;

}
