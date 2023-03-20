package org.barp.backend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class MoneyAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long accountId;
    public Long balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    public User user;

    @OneToMany(mappedBy = "moneyAccount", cascade = {CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonManagedReference
    public List<Transaction> transactions;
}
