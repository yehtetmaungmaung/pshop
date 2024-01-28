package dev.thoon.pshop.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "producer")
public class Producer implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private List<Product> products;

    public Producer() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @OneToMany(mappedBy = "producer", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonIgnore
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Producer(ProducerBuilder producerBuilder) {
        this.id = producerBuilder.id;
        this.name = producerBuilder.name;
        this.products = producerBuilder.products;
    }

    public static class ProducerBuilder {

        private Long id;
        private String name;
        private List<Product> products;

        public ProducerBuilder() {

        }


        public ProducerBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ProducerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProducerBuilder setProducts(List<Product> products) {
            this.products = products;
            return this;
        }


        public Producer build() {
            return new Producer(this);
        }
        
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Producer producer = (Producer) o;
        return Objects.equals(id, producer.id) &&
                Objects.equals(name, producer.name);
    }
}
