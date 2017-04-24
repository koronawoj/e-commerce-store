package pl.koronawoj.model.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by z00382545 on 10/20/16.
 */

@Entity
public class Role {
    @Id
    private int roleId;

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CustomerRole> CustomerRoles = new HashSet<>();

    public Role() {

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CustomerRole> getUserRoles() {
        return CustomerRoles;
    }

    public void setUserRoles(Set<CustomerRole> userRoles) {
        this.CustomerRoles = userRoles;
    }


}
