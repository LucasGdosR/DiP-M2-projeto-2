package tech.devinhouse.labmedical.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotBlank
    private String laboratory;
    private String fileUrl;
    @NotBlank
    private String results;
    private Integer patientId;
}
