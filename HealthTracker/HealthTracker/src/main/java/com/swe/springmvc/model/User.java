package com.swe.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name="HT_USER")
public class User implements Serializable{
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @NotEmpty
    @Column(name="USERNAME", unique=true, nullable=false)
    private String username;
     
    @NotEmpty
    @Column(name="PASSWORD", nullable=false)
    private String password;
         
    @NotEmpty
    @Column(name="FIRST_NAME", nullable=false)
    private String firstName;
 
    @NotEmpty
    @Column(name="LAST_NAME", nullable=false)
    private String lastName;
    
    @Column(name="BIRTHDATE", nullable=false)
    private Date birthdate;
    
    @NotEmpty
    @Column(name="GENDER", nullable=false)
    private String gender;
    
    @Column(name="HEIGHT", nullable=false)
    private BigDecimal height;
    
    @Column(name="WEIGHT", nullable=false)
    private BigDecimal weight;
//    birthdate DATE NOT NULL,
//    gender VARCHAR(30) NOT NULL,
//    height DECIMAL(3,2) NOT NULL,
//    weight DECIMAL(4,1) NOT NULL,
 
    @NotEmpty
    @Column(name="EMAIL", nullable=false)
    private String email;
 
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "HT_USER_USER_ROLE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_ROLE_ID") })
    private Set<UserRole> userRoles = new HashSet<UserRole>();
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }
 
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
 

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + "]";
    }
 
 
     
}
