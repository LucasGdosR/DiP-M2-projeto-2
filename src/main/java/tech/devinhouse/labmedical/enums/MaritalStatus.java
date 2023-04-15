package tech.devinhouse.labmedical.enums;

public enum MaritalStatus {
    SINGLE("Solteiro"),
    MARRIED("Casado"),
    SEPARATED("Separado"),
    DIVORCED("Divorciado"),
    WIDOWED("Viúvo");

    private final String status;

    MaritalStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
