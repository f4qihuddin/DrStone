package model;

import java.util.UUID;

public class Bookmark
{
    private UUID bookmarkID;
    private String bookmarkName;
    private UUID userID;
    private UUID stoneID;

    public Bookmark(String bookmarkName, UUID userID, UUID stoneID)
    {
        UUID uuid = UUID.randomUUID();
        this.setBookmarkID(uuid);
        this.setBookmarkName(bookmarkName);
        this.setStoneID(stoneID);
        this.setUserID(userID);
    }

    public void setBookmarkID(UUID bookmarkID)
    {
        this.bookmarkID = bookmarkID;
    }

    public UUID getBookmarkID()
    {
        return bookmarkID;
    }

    public void setBookmarkName(String bookmarkName)
    {
        this.bookmarkName = bookmarkName;
    }

    public String getBookmarkName()
    {
        return bookmarkName;
    }

    public void setStoneID(UUID stoneID)
    {
        this.stoneID = stoneID;
    }

    public UUID getStoneID()
    {
        return stoneID;
    }

    public void setUserID(UUID userID)
    {
        this.userID = userID;
    }

    public UUID getUserID()
    {
        return userID;
    }
}
