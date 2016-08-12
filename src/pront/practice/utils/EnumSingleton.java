package pront.practice.utils;

/**
 * Created by prontidis on 29/06/14.
 */
public enum EnumSingleton {
    INSTANCE;

    private String description;

    public void setDescription(String description) {
        this.description = new String(description);
    }
    public String toString() {
        return description;
    }
}