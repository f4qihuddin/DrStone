package model;

import java.util.UUID;

public class Stone {
    private UUID stoneID;
    private String name;
    private byte[] image;
    private String description;
    private String characteristics;
    private String googleScholar;
    private String web;
    private String youtube;
    private String subCategory;
    private UUID subCategoryID;


    public Stone(String name, byte[] image, String description, String characteristics, String googleScholar, String web, String youtube){
        this.setName(name);
        this.setImage(image);
        this.setDescription(description);
        this.setCharacteristics(characteristics);
        this.setGoogleScholar(googleScholar);
        this.setWeb(web);
        this.setYoutube(youtube);
    }

    public Stone(UUID stoneID, String name, byte[] image, String description, String characteristics, String googleScholar, String web, String youtube, String subCategory){
        this.setStoneID(stoneID);
        this.setName(name);
        this.setImage(image);
        this.setDescription(description);
        this.setCharacteristics(characteristics);
        this.setGoogleScholar(googleScholar);
        this.setWeb(web);
        this.setYoutube(youtube);
        this.setSubCategory(subCategory);
    }

    public Stone(String name, String description, byte[] image, String characteristics, String googleScholar, String web, String youtube, UUID subCategoryID){
        UUID uuid = UUID.randomUUID();
        this.setStoneID(uuid);
        this.setName(name);
        this.setDescription(description);
        this.setImage(image);
        this.setCharacteristics(characteristics);
        this.setGoogleScholar(googleScholar);
        this.setWeb(web);
        this.setYoutube(youtube);
        this.setSubCategoryID(subCategoryID);
    }

    public Stone(UUID stoneID, String name, byte[] image, String description, String characteristics, String googleScholar, String web, String youtube, UUID subCategoryID)
    {
        this.setStoneID(stoneID);
        this.setName(name);
        this.setImage(image);
        this.setDescription(description);
        this.setCharacteristics(characteristics);
        this.setGoogleScholar(googleScholar);
        this.setWeb(web);
        this.setYoutube(youtube);
        this.setSubCategoryID(subCategoryID);
    }

    public void setStoneID(UUID stoneID)
    {
        this.stoneID = stoneID;
    }

    public UUID getStoneID()
    {
        return stoneID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setImage(byte[] image){
        this.image = image;
    }

    public byte[] getImage(){
        return image;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCharacteristics(String characteristics){
        this.characteristics = characteristics;
    }

    public String getCharacteristics(){
        return characteristics;
    }

    public void setGoogleScholar(String googleScholar){
        this.googleScholar = googleScholar;
    }

    public String getGoogleScholar(){
        return googleScholar;
    }

    public void setWeb(String web){
        this.web = web;
    }

    public String getWeb(){
        return web;
    }

    public void setYoutube(String youtube){
        this.youtube = youtube;
    }

    public String getYoutube(){
        return youtube;
    }

    public void setSubCategory(String subCategory){
        this.subCategory = subCategory;
    }

    public String getSubCategory(){
        return subCategory;
    }

    public void setSubCategoryID(UUID subCategoryID)
    {
        this.subCategoryID = subCategoryID;
    }

    public UUID getSubCategoryID()
    {
        return subCategoryID;
    }
}
