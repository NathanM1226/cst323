package com.gcu.models;

public class ProductModel {
    long id;
    String gadgetName;
    int dateOfOrigin;
    int lethalityRating;
    String photoFileName;
    String instructions;
    String description; 
    Float price;
    
    public ProductModel(){
        
    }

    public ProductModel(long id, String gadgetName, int dateOfOrigin, int lethalityRating, String photoFileName,
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
        return "ProductModel [id=" + id + ", gadgetName=" + gadgetName + ", dateOfOrigin=" + dateOfOrigin
                + ", lethalityRating=" + lethalityRating + ", photoFileName=" + photoFileName + ", instructions="
                + instructions + ", description=" + description + ", price=" + price + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long l) {
        this.id = l;
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
