package com.bta;

public class Country {
    private long id;
    private String name;
    private int population;
    private int year_establis;
    private String description;

    public Country(long id, String name, int population, int year_establis, String description) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.year_establis = year_establis;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getYear_establis() {
        return year_establis;
    }

    public void setYear_establis(int year_establis) {
        this.year_establis = year_establis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country(String name, int population, int year_establis, String description) {
        this.name = name;
        this.population = population;
        this.year_establis = year_establis;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", year_establis=" + year_establis +
                ", description='" + description + '\'' +
                '}';
    }
}
