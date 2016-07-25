package com.countries.countrylist.data;

import com.countries.countrylist.model.Country;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.lang.Long.compare;

/*Population data fetched from www.worldometers.info*/
@Component
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("United States of America", "324,280,220",
                        Collections.singletonList("English (Unofficial, but primary)"),
                        Collections.singletonList("Washington, DC"), "Flag_of_the_United_States"),
            new Country("Russia", "143,438,660", Collections.singletonList("Russian"),
                        Collections.singletonList("Moscow"), "Flag_of_Russia"),
            new Country("Romania", "19,363,266", Collections.singletonList("Romanian"),
                        Collections.singletonList("Bucharest"), "Flag_of_Romania"),
            new Country("Belgium", "11,376,933", Arrays.asList("French","Dutch","German"),
                        Collections.singletonList("City of Brussels"), "Flag_of_Belgium"),
            new Country("South Africa", "55,012,573",
                        Arrays.asList("Afrikaans","Northern Sotho","English","Southern Ndebele", "Southern Sotho",
                                      "Swazi","Tsonga","Tswana","Venda","Xhosa","Zulu"),
                        Arrays.asList("Pretoria (Executive)","Bloemfontein (Judicial)", "Cape Town (Legislative)"),
                        "Flag_of_South_Africa")
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country findBySlug(String slug) {
        return ALL_COUNTRIES.stream()
                    .filter(country -> country.getSlug().equals(slug))
                    .findFirst()
                    .orElse(null);
    }

    private Comparator<Country> byName = (a, b) -> a.getName().compareTo(b.getName());

    private Comparator<Country> byPopulation = (b, a) -> compare(Long.valueOf(a.getPopulation().replaceAll(",","")),
                                                                Long.valueOf(b.getPopulation().replaceAll(",","")));

    public List<Country> countriesByName() {
        List<Country> countries = new ArrayList<>(ALL_COUNTRIES);
        countries.sort(byName);
        return countries;
    }

    public List<Country> countriesByPopulation() {
        List<Country> countries = new ArrayList<>(ALL_COUNTRIES);
        countries.sort(byPopulation);
        return countries;
    }
}
