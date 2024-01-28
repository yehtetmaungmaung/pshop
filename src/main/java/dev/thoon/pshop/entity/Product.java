package dev.thoon.pshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonView;

import dev.thoon.pshop.utils.Views;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String name;
    private Subcategory subcategory;
    private String description;
    private String imgLink;

    @JsonView(Views.Public.class)
    private BigDecimal price;
    private Producer producer;
    private SpecCategory specCategory;
    private String visible;
    private Date date;

    public Product() {
    }

    /**
     * Get the date.
     * 
     * @return the date
     */
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    /**
     * Set the date for the object.
     * 
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * A method to get the value of the visible field.
     *
     * @return the value of the visible field
     */
    @Basic
    @Column(name = "visible")
    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_specCategory", foreignKey = @ForeignKey(name = "fk_product_specCategory"))
    public SpecCategory getSpecCategory() {
        return specCategory;
    }

    public void setSpecCategory(SpecCategory specCategory) {
        this.specCategory = specCategory;
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

    /**
     * Get the producer of the product.
     * 
     * @return The producer of the product
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_producer", foreignKey = @ForeignKey(name = "fk_product_producer"))
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_subcategory", foreignKey = @ForeignKey(name = "fk_product_subcategory"))
    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the imgLink.
     *
     * @return the imgLink
     */
    @Basic
    @Column(name = "imgLink")
    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product(ProductBuilder productBuilder) {
        this.id = productBuilder.id;
        this.name = productBuilder.name;
        this.subcategory = productBuilder.subcategory;
        this.description = productBuilder.description;
        this.imgLink = productBuilder.imgLink;
        this.price = productBuilder.price;
        this.producer = productBuilder.producer;
        this.specCategory = productBuilder.specCategory;
        this.visible = productBuilder.visible;
        this.date = productBuilder.date;
    }

    public static class ProductBuilder {
        private Long id;
        private String name;
        private Subcategory subcategory;
        private String description;
        private String imgLink;
        private BigDecimal price;
        private Producer producer;
        private SpecCategory specCategory;
        private String visible;
        private Date date;

        public ProductBuilder() {

        }

        public ProductBuilder setProducer(Producer producer) {
            this.producer = producer;
            return this;
        }

        public ProductBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setSubcategory(Subcategory subcategory) {
            this.subcategory = subcategory;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setImgLink(String imgLink) {
            this.imgLink = imgLink;
            return this;
        }

        public ProductBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setSpecCategory(SpecCategory specCategory) {
            this.specCategory = specCategory;
            return this;
        }

        public ProductBuilder setVisible(String visible) {
            this.visible = visible;
            return this;
        }

        public ProductBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }

    /**
     * Checks if the given object is equal to this product.
     *
     * @param o the object to compare
     * @return true if the given object is equal to this product, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true; // If the objects are the same, they are equal
        if (o == null || getClass() != o.getClass())
            return false; // If the class of the compared object is different, they are not equal
        Product product = (Product) o; // Cast the compared object to Product class
        // Compare each attribute of the product
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(subcategory, product.subcategory) &&
                Objects.equals(description, product.description) &&
                Objects.equals(imgLink, product.imgLink) &&
                Objects.equals(price, product.price) &&
                Objects.equals(producer, product.producer) &&
                Objects.equals(specCategory, product.specCategory) &&
                Objects.equals(visible, product.visible) &&
                Objects.equals(date, product.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subcategory, description, imgLink,
                price, producer, specCategory, visible, date);
    }

    /**
     * Returns a string representation of the Product object.
     * 
     * @return the string representation of the Product object
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subcategory=" + subcategory +
                ", description='" + description + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", price=" + price +
                ", producer=" + producer +
                ", specCategory=" + specCategory +
                ", visible='" + visible + '\'' +
                ", date=" + date +
                '}';
    }

    // @Override
    // public String toString() {
    //     return new StringBuilder("Product{").append("id=").append(id).append(", name=").append(name).toString();

    // }
}
