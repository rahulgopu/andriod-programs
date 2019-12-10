package z1840816.edu.niu.cs;

/********************************************************************
 CSCI 522 - Portfolio 7 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will function as an image gallery.

 *********************************************************************/

public class Character
{
    private String characterDescription;
    private int characterID;

    public Character(String description, int iD)
    {
        this.characterDescription = description;
        this.characterID = iD;
    }

    public String getCharacterDescription() {
        return characterDescription;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterDescription(String description) {
        this.characterDescription = description;
    }

    public void setCharacterID(int newID) {
        this.characterID = newID;
    }
}
