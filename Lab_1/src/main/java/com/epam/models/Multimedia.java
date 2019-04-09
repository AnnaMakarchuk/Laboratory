package com.epam.models;

public class Multimedia extends ElectricalAppliance {
    private MultimediaType multiMediaType;

    public Multimedia(String applianceName, String brand, int powerConsumption, int yearProduction, boolean turnOn
            , MultimediaType multiMediaType) {
        super(applianceName, brand, powerConsumption, yearProduction, turnOn);
        this.multiMediaType = multiMediaType;
    }

    public MultimediaType getMultiMediaType() {
        return multiMediaType;
    }

    public void setMultiMediaType(MultimediaType multiMediaType) {
        this.multiMediaType = multiMediaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Multimedia)) return false;
        if (!super.equals(o)) return false;

        Multimedia that = (Multimedia) o;

        return multiMediaType == that.multiMediaType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (multiMediaType != null ? multiMediaType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nMultiMedia {" + super.toString()+
                "multiMediaType= " + multiMediaType +
                '}';
    }
}
