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
@Table(name = "spec_category")
public class SpecCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private List<Product> productList;

    public SpecCategory() {
    }


    @OneToMany(mappedBy = "specCategory", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JsonIgnore
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public SpecCategory(SpecCategoryBuilder specCategoryBuilder) {
        this.id = specCategoryBuilder.id;
        this.name = specCategoryBuilder.name;
        this.productList = specCategoryBuilder.productList;
    }


    public class SpecCategoryBuilder {
        private int id;
        private String name;
        private List<Product> productList;
        public SpecCategoryBuilder() {
        }
        
        public SpecCategoryBuilder setId(int id) {
            this.id = id;
            return this;
        }
        
        public SpecCategoryBuilder setName(String name) {
            this.name = name;
            return this;
        }
        
        public SpecCategoryBuilder setProductList(List<Product> productList) {
            this.productList = productList;
            return this;
        }
        
        public SpecCategory build() {
            return new SpecCategory(this);
        }
        
    }


    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If the objects are the same, they are equal
        if (o == null || getClass() != o.getClass()) return false; // If the class of the compared object is different, they are not equal
        SpecCategory that = (SpecCategory) o; // Cast the compared object to SpecCategory class
        return id == that.id &&
                name.equals(that.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
}
