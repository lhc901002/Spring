package org.michaelliu.spring.beans;

import java.util.List;

/**
 * Created by Michael on 7/15/16.
 */
public class UserInfo {

    private Long id;

    private String email;

    private List<String> addressBook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<String> addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", addressBook=" + addressBook +
                '}';
    }

}
