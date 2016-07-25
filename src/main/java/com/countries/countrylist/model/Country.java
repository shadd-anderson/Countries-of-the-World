package com.countries.countrylist.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.util.List;


public class Country {
    private String name;
    private String population;
    private List<String> languages;
    private List<String> capitol;
    private String slug;
    private String flagName;
    private boolean multipleLang;
    private boolean multipleCap;

    public Country(String name, String population, List<String> languages, List capitol, String flagName) {
        this.name = name;
        this.population = population;
        this.languages = languages;
        this.capitol = capitol;
        this.flagName = flagName;

        try {
            Slugify slugy = new Slugify();
            slug = slugy.slugify(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List getCapitol() {
        return capitol;
    }

    public void setCapitol(List capitol) {
        this.capitol = capitol;
    }

    public String getSlug() {
        return slug;
    }

    public String getFlagName() {
        return flagName;
    }

    public boolean isMultipleLang() {
        return languages.size() > 1;
    }

    public boolean isMultipleCap() {
        return capitol.size() > 1;
    }
}
