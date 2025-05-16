package com.jandir.paises.model;

public class Pais {
    private String nome;
    private String capital;
    private String continente;
    private String bandeiraUrl;

    public Pais(String nome, String capital, String continente, String bandeiraUrl) {
        this.nome = nome;
        this.capital = capital;
        this.continente = continente;
        this.bandeiraUrl = bandeiraUrl;
    }

    public String getNome() { return nome; }
    public String getCapital() { return capital; }
    public String getContinente() { return continente; }
    public String getBandeiraUrl() { return bandeiraUrl; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCapital(String capital) { this.capital = capital; }
    public void setContinente(String continente) { this.continente = continente; }
    public void setBandeiraUrl(String bandeiraUrl) { this.bandeiraUrl = bandeiraUrl; }
}
