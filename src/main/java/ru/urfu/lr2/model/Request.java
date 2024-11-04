package ru.urfu.lr2.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank
    @Length(max = 32)
    private String uid;
    @NotBlank
    @Length(max = 32)
    private String operationUid;
    private String systemName;
    @NotBlank
    private String systemTime;
    private String source;
    @Min(1)
    @Max(100000)
    private Integer communicationId;
    private Integer templateId;
    private Integer productCode;
    private Integer smsCode;
}