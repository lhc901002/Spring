package org.michaelliu.spring.ioc.beans;

import org.michaelliu.spring.beans.Account;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by michael on 2016/8/2.
 */
public class Manager {

    private Long id;

    private Account account;

    private List<String> cities;

    private Set<String> countries;

    private Map<Long, String> persons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Set<String> getCountries() {
        return countries;
    }

    public void setCountries(Set<String> countries) {
        this.countries = countries;
    }

    public Map<Long, String> getPersons() {
        return persons;
    }

    public void setPersons(Map<Long, String> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", account=" + account +
                ", cities=" + cities +
                ", countries=" + countries +
                ", persons=" + persons +
                '}';
    }

}
