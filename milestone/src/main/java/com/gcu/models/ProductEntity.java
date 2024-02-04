package com.gcu.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCTS")
public class ProductEntity {
    @Id
    @Column("ID")
    Long id = 0L;

    @Column("GADGET_NAME")
    String gadgetName;

    @Column("DATE_OF_ORIGIN")
    int dateOfOrigin;

    @Column("LETHALITY_RATING")
    int lethalityRating;

    @Column("PHOTO_FILE_NAME")
    String photoFileName;

    @Column("INSTRUCTIONS")
    String instructions;

    @Column("DESCRIPTION")
    String description; 

    @Column("PRICE")
    Float price;

    public ProductEntity(Long id, String gadgetName, int dateOfOrigin, int lethalityRating, String photoFileName,
            String instructions, String description, Float price) {
        this.id = id;
        this.gadgetName = gadgetName;
        this.dateOfOrigin = dateOfOrigin;
        this.lethalityRating = lethalityRating;
        this.photoFileName = photoFileName;
        this.instructions = instructions;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductEntity [id=" + id + ", gadgetName=" + gadgetName + ", dateOfOrigin=" + dateOfOrigin
                + ", lethalityRating=" + lethalityRating + ", photoFileName=" + photoFileName + ", instructions="
                + instructions + ", description=" + description + ", price=" + price + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }

    public int getDateOfOrigin() {
        return dateOfOrigin;
    }

    public void setDateOfOrigin(int dateOfOrigin) {
        this.dateOfOrigin = dateOfOrigin;
    }

    public int getLethalityRating() {
        return lethalityRating;
    }

    public void setLethalityRating(int lethalityRating) {
        this.lethalityRating = lethalityRating;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    
}
