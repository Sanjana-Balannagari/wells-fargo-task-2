package com.wellsfargo.portfolio.entities;

//import javax.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Portfolio Entity
@Entity
@Table(name = "Portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PortfolioID")
    private Integer portfolioId;

    @OneToOne
    @JoinColumn(name = "ClientID", nullable = false)
    private Client client;

    @Column(name = "PortfolioName", nullable = false)
    private String portfolioName;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "TotalValue", nullable = false)
    private Double totalValue;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();

    // Constructor
    public Portfolio(Client client, String portfolioName, LocalDateTime createdAt, LocalDateTime updatedAt, Double totalValue) {
        this.client = client;
        this.portfolioName = portfolioName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalValue = totalValue;
    }

    // Default constructor for JPA
    public Portfolio() {}

    // Getters
    public Integer getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    // Setters
    public void setClient(Client client) {
        this.client = client;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
