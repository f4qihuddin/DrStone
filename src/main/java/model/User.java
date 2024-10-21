package model;

import java.util.UUID;

public class User
{
    private UUID idUser;
    private String username;
    private String password;

    public User(String username, String password)
    {
        UUID uuid = UUID.randomUUID();
        this.setIdUser(uuid);
        this.setPassword(password);
        this.setUsername(username);
    }

    public User(UUID idUser, String username, String password)
    {
        this.setIdUser(idUser);
        this.setPassword(password);
        this.setUsername(username);
    }



    public UUID getIdUser()
    {
        return idUser;
    }

    public void setIdUser(UUID idUser)
    {
        this.idUser = idUser;
    }


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}

