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
@Table(name = "category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String url;
    private List<Subcategory> subcategoryList;

    public Category() {
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

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JsonIgnore
    public List<Subcategory> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(CategoryBuilder categoryBuilder) {
        this.id = categoryBuilder.id;
        this.name = categoryBuilder.name;
        this.url = categoryBuilder.url;
        this.subcategoryList = categoryBuilder.subcategoryList;
    }

    public static class CategoryBuilder {
        private int id;
        private String name;
        private String url;
        private List<Subcategory> subcategoryList;

        public CategoryBuilder() {

        }

        public CategoryBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CategoryBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public CategoryBuilder setSubcategoryList(List<Subcategory> subcategoryList) {
            this.subcategoryList = subcategoryList;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If the objects are the same, they are equal
        if (o == null || getClass() != o.getClass()) return false; // If the class of the compared object is different, they are not equal
        Category category = (Category) o; // Cast the compared object to Category class
        return id == category.id &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
