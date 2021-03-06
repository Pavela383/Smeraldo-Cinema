package it.univaq.disim.mobile.smeraldocinema.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "screenings")
public class Screening implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "screening_id")
    private Long id;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM", timezone="Europe/Rome")
    @Column(name = "day", nullable = false)
    private Date day;

    @Column(name = "hour", nullable = false)
    private String hour;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;
    
    @JsonIgnore
    @OneToMany(mappedBy = "id.screening")
    private List<Booking> bookings = new ArrayList();

    @JsonIgnore
    @OneToMany(mappedBy = "id.screening")
    private List<Purchase> purchases = new ArrayList();
    
    public Screening() {
    }
    
    public Screening(Long id, Date day, String hour, Theater theater, Film film) {
        this.id = id;
        this.day = day;
        this.hour = hour;
        this.theater = theater;
        this.film = film;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Theater getTheater(){
        return theater;
    }
    
    public void setTheater(Theater theater){
        this.theater = theater;
    }
    
    public Film getFilm(){
        return film;
    }
    
    public void setFilm(Film film){
        this.film = film;
    }
    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Purchase> getPurchases() {
        return this.purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
