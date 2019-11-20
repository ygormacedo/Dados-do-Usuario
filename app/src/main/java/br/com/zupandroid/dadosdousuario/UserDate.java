package br.com.zupandroid.dadosdousuario;

import java.io.Serializable;

public class UserDate implements Serializable {

    private String name, lastName, telephone, celphone, cpf, schooling, zipCode, neighborhood, stats, rePassword, rg, password;


    public UserDate() {
    }

    public UserDate(String name, String lastName, String telephone, String celphone, String cpf, String schooling, String zipCode, String neighborhood, String stats, String rePassword, String rg, String password) {
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.celphone = celphone;
        this.cpf = cpf;
        this.schooling = schooling;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
        this.stats = stats;
        this.rePassword = rePassword;
        this.rg = rg;
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
