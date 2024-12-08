package hu.unideb.inf.model;

import hu.unideb.inf.enums.RentalStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<RentalItem> rentalItems;

    private LocalDate rentalDate;

    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Rental() {}

    public Rental(LocalDate rentalDate, LocalDate returnDate, RentalStatus status, User user) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.status = status;
        this.user = user;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
