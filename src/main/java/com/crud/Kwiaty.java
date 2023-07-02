package com.crud;

import javax.persistence.*;

@Entity
@Table(name = "Kwiaty")
public class Kwiaty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "kolor")
    private String kolor;

    @Column(name = "ilosc")
    private int ilosc;

    @Column(name = "rodzaj")
    private String rodzaj;

    // Konstruktory
    public Kwiaty() {
    }

    public Kwiaty(long id,String nazwa, String kolor, int ilosc, String rodzaj) {
        this.id = id;
        this.nazwa = nazwa;
        this.kolor = kolor;
        this.ilosc = ilosc;
        this.rodzaj = rodzaj;
    }

    // Gettery i Settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }


    @Override
    public String toString() {
        return "Kwiaty{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", kolor='" + kolor + '\'' +
                ", ilosc=" + ilosc +
                ", rodzaj='" + rodzaj + '\'' +
                '}';
    }
}
