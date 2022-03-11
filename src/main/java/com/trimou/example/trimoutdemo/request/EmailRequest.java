package com.trimou.example.trimoutdemo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailRequest {
    private String from;
    private String to;
    private String language;
    private String emailName;
}
