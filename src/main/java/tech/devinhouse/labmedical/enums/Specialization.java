package tech.devinhouse.labmedical.enums;

public enum Specialization {
    CLINICO_GERAL("Clínico Geral"),
    ANESTESISTA("Anestesista"),
    DERMATOLOGIA("Dermatologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    PSIQUIATRIA("Psiquiatria"),
    ORTOPEDIA("Ortopedia");

    private final String specialization;

    Specialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
