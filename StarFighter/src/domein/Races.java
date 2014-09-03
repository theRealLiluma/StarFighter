package domein;

public enum Races {
    TERRAN("terran");

    private final String raceName;

    private Races(String raceName)
    {
        this.raceName = raceName;
    }

    public String getMessage()
    {
        return raceName;
    }
}