package tech.devinhouse.labmedical.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Statistics {
    private Integer patients;
    private Integer appointments;
    private Integer exams;
}
