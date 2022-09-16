package edu.bd.addressbook;

public class AddressData {

    private String name;
    private String email;
    private String presentadd;
    private String permanentadd;
    private String phoneh;
    private String phoneo;

    public AddressData(){

    }

    public AddressData(String name, String email, String presentadd, String permanentadd, String phoneh, String phoneo) {
        this.name = name;
        this.email = email;
        this.presentadd = presentadd;
        this.permanentadd = permanentadd;
        this.phoneh = phoneh;
        this.phoneo = phoneo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPresentadd() {
        return presentadd;
    }

    public String getPermanentadd() {
        return permanentadd;
    }

    public String getPhoneh() {
        return phoneh;
    }

    public String getPhoneo() {
        return phoneo;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPresentadd(String presentadd) {
        this.presentadd = presentadd;
    }

    public void setPermanentadd(String permanentadd) {
        this.permanentadd = permanentadd;
    }

    public void setPhoneh(String phoneh) {
        this.phoneh = phoneh;
    }

    public void setPhoneo(String phoneo) {
        this.phoneo = phoneo;
    }
}
