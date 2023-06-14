package com.example.frutas;

public class Contacto {
    public int id;
    public int IVP;
    public String TVP;
    public String TVNP;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIVP() {
        return IVP;
    }

    public void setIVP(int IVP) {
        this.IVP = IVP;
    }

    public String getTVP() {
        return TVP;
    }

    public void setTVP(String TVP) {
        this.TVP = TVP;
    }

    public String getTVNP() {
        return TVNP;
    }

    public void setTVNP(String TVNP) {
        this.TVNP = TVNP;
    }

    public Contacto(int id, int IVP, String TVP, String TVNP) {
        this.id = id;
        this.IVP = IVP;
        this.TVP = TVP;
        this.TVNP = TVNP;
    }
}
