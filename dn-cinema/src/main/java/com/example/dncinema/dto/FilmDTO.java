package com.example.dncinema.dto;

import com.example.dncinema.model.ShowTime;
import com.example.dncinema.model.TypeFilm;

import java.time.LocalDate;

public class FilmDTO {
    private Integer idFilm;
    private String nameFilm;
    private String director;
    private String studioFilm;
    private String trailer;
    private String describeFilm;
    private String actor;
    private Double normalSeatPrice;
    private Double vipSeatPrice;
    private LocalDate dateStartFilm;
    private LocalDate dateEndFilm;
    private String imgFilm;
    private Integer timeFilm;
    private String movieLabel;
    private TypeFilm typeFilm;
    private ShowTime showTime;

    public FilmDTO() {
    }

    public FilmDTO(Integer idFilm, String nameFilm, String director, String studioFilm, String trailer, String describeFilm, String actor, Double normalSeatPrice, Double vipSeatPrice, LocalDate dateStartFilm, LocalDate dateEndFilm, String imgFilm, Integer timeFilm, String movieLabel, TypeFilm typeFilm, ShowTime showTime) {
        this.idFilm = idFilm;
        this.nameFilm = nameFilm;
        this.director = director;
        this.studioFilm = studioFilm;
        this.trailer = trailer;
        this.describeFilm = describeFilm;
        this.actor = actor;
        this.normalSeatPrice = normalSeatPrice;
        this.vipSeatPrice = vipSeatPrice;
        this.dateStartFilm = dateStartFilm;
        this.dateEndFilm = dateEndFilm;
        this.imgFilm = imgFilm;
        this.timeFilm = timeFilm;
        this.movieLabel = movieLabel;
        this.typeFilm = typeFilm;
        this.showTime = showTime;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudioFilm() {
        return studioFilm;
    }

    public void setStudioFilm(String studioFilm) {
        this.studioFilm = studioFilm;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDescribeFilm() {
        return describeFilm;
    }

    public void setDescribeFilm(String describeFilm) {
        this.describeFilm = describeFilm;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Double getNormalSeatPrice() {
        return normalSeatPrice;
    }

    public void setNormalSeatPrice(Double normalSeatPrice) {
        this.normalSeatPrice = normalSeatPrice;
    }

    public Double getVipSeatPrice() {
        return vipSeatPrice;
    }

    public void setVipSeatPrice(Double vipSeatPrice) {
        this.vipSeatPrice = vipSeatPrice;
    }

    public LocalDate getDateStartFilm() {
        return dateStartFilm;
    }

    public void setDateStartFilm(LocalDate dateStartFilm) {
        this.dateStartFilm = dateStartFilm;
    }

    public LocalDate getDateEndFilm() {
        return dateEndFilm;
    }

    public void setDateEndFilm(LocalDate dateEndFilm) {
        this.dateEndFilm = dateEndFilm;
    }

    public String getImgFilm() {
        return imgFilm;
    }

    public void setImgFilm(String imgFilm) {
        this.imgFilm = imgFilm;
    }

    public Integer getTimeFilm() {
        return timeFilm;
    }

    public void setTimeFilm(Integer timeFilm) {
        this.timeFilm = timeFilm;
    }

    public String getMovieLabel() {
        return movieLabel;
    }

    public void setMovieLabel(String movieLabel) {
        this.movieLabel = movieLabel;
    }

    public TypeFilm getTypeFilm() {
        return typeFilm;
    }

    public void setTypeFilm(TypeFilm typeFilm) {
        this.typeFilm = typeFilm;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }
}
