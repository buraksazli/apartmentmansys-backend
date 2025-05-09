package com.myapartment.apartment_management.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a flat within an apartment building.
 */
@Entity
@Table(name = "flats")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Column(name = "flat_number", length = 10, nullable = false)
    private String flatNumber;

    @Column(name = "floor_number", nullable = false)
    private Integer floorNumber;

    @Column(name = "area", nullable = false)
    private Integer area;

    @Column(name = "num_bedrooms")
    private Integer numBedrooms;

    @Column(name = "num_bathrooms")
    private Integer numBathrooms;

    @ManyToOne
    @JoinColumn(name = "owner_user_id")
    private FlatOwnerProfile owner;

    @OneToMany(mappedBy = "flat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FlatOccupant> flatOccupants = new HashSet<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Default constructor
    public Flat() {
    }

    // Constructor with fields
    public Flat(Apartment apartment, String flatNumber, Integer floorNumber, Integer area, Integer numBedrooms,
                Integer numBathrooms, FlatOwnerProfile owner) {
        this.apartment = apartment;
        this.flatNumber = flatNumber;
        this.floorNumber = floorNumber;
        this.area = area;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.owner = owner;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Integer getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(Integer numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public Integer getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(Integer numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public FlatOwnerProfile getOwner() {
        return owner;
    }

    public void setOwner(FlatOwnerProfile owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", apartment=" + (apartment != null ? apartment.getId() : null) +
                ", flatNumber='" + flatNumber + '\'' +
                ", floorNumber=" + floorNumber +
                ", area=" + area +
                ", numBedrooms=" + numBedrooms +
                ", numBathrooms=" + numBathrooms +
                ", owner=" + (owner != null ? owner.getUserId() : null) +
                ", createdAt=" + createdAt +
                '}';
    }

    public Set<FlatOccupant> getFlatOccupants() {
        return flatOccupants;
    }

    public void setFlatOccupants(Set<FlatOccupant> flatOccupants) {
        this.flatOccupants = flatOccupants;
    }
}