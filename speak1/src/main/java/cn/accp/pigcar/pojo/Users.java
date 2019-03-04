package cn.accp.pigcar.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Users implements Serializable {

    //分页字段
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }


    private static final long serialVersionUID = 1L;

    private String username;
    private Roles roles;
    private String identity;
    private String fullname;
    private String sex;
    private String address;
    private String phone;
    private String position;
    private int userLevel;
    private String userpwd;

    private Set renttables = new HashSet(0);
    private Set checktables = new HashSet(0);


    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }





    public Users() {
    }

    public Users(String username, Roles roles, String identity,
                 String fullname, String sex, String address, String phone,
                 String position, String userpwd) {
        this.username = username;
        this.roles = roles;
        this.identity = identity;
        this.fullname = fullname;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.position = position;
        this.userpwd = userpwd;
    }

    public Users(String username, Roles roles, String identity,
                 String fullname, String sex, String address, String phone,
                 String position, String userpwd, Set renttables, Set checktables) {
        this.username = username;
        this.roles = roles;
        this.identity = identity;
        this.fullname = fullname;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.position = position;
        this.userpwd = userpwd;
        this.renttables = renttables;
        this.checktables = checktables;
    }



    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Roles getRoles() {
        return this.roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Users other = (Users) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserpwd() {
        return this.userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public Set getRenttables() {
        return this.renttables;
    }

    public void setRenttables(Set renttables) {
        this.renttables = renttables;
    }

    public Set getChecktables() {
        return this.checktables;
    }

    public void setChecktables(Set checktables) {
        this.checktables = checktables;
    }

}
