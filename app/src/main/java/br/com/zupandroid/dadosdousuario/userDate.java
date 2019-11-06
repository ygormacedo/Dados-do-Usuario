package br.com.zupandroid.dadosdousuario;

import java.io.Serializable;

public class userDate implements Serializable {

    private String name, lastName, telephone, celphone, cpf, schooling, zipCode, neighborhood, stats;

    public userDate() {
    }

    public userDate(String name, String lastName, String telephone, String celphone, String cpf, String schooling, String zipcode, String neighborhood, String stats) {
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.celphone = celphone;
        this.cpf = cpf;
        this.schooling = schooling;
        this.zipCode = zipcode;
        this.neighborhood = neighborhood;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCelphone() {
        return celphone;
    }

    public void setCelphone(String celphone) {
        this.celphone = celphone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSchooling() {
        return schooling;
    }

    public void setSchooling(String schooling) {
        this.schooling = schooling;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }
}
