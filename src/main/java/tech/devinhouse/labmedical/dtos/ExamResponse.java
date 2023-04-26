package tech.devinhouse.labmedical.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamResponse {
    private String name;
    private String dateTime;
    private String type;
    private String laboratory;
    private String file;
    private String results;
    private Integer patientId;
    private Integer doctorId;
}
