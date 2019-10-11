package com.casestudy.eCart.Modal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private int quantity;
    @ManyToOne
    private Items items;
    @ManyToOne
    private Users users;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }




}
