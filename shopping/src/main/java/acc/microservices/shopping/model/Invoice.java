package acc.microservices.shopping.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import acc.microservices.shopping.model.pojos.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import lombok.Data;

@Data
@Entity
public class Invoice {
  public Invoice() {
    items = new ArrayList<>();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String numberInvoice;

  private String description;

  private Long customerId;

  @Temporal(TemporalType.DATE)
  private Date createAt;

  @Valid
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_invoice")
  private List<InvoiceItem> items;

  private String state;

  @Transient
  private Customer customer;

  @PrePersist
  public void prePersist() {
    this.createAt = new Date();
  }
}
