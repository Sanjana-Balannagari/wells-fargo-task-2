package com.wellsfargo.portfolio.entities;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

// Security Entity
@Entity
@Table(name = "Security")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SecurityID")
    private Integer securityId;

    @ManyToOne
    @JoinColumn(name = "PortfolioID", nullable = false)
    private Portfolio portfolio;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Category", nullable = false)
    private String category;

    @Column(name = "PurchaseDate", nullable = false)
    private LocalDateTime purchaseDate;

    @Column(name = "PurchasePrice", nullable = false)
    private Double purchasePrice;

    @Column(name = "Quantity", nullable = false)
    private Double quantity;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    // Constructor
    public Security(Portfolio portfolio, String name, String category, LocalDateTime purchaseDate, Double purchasePrice, Double quantity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.portfolio = portfolio;
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Default constructor for JPA
    public Security() {}

    // Getters
    public Integer getSecurityId() {
        return securityId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}