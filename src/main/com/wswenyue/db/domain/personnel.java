package main.com.wswenyue.db.domain;

public class personnel {
    String ID;
    String name;
    Integer age;
    String sex;
    String ID_number;
    String phone_number;
    String Face_ID;
    String address;
    String post;

    @Override
    public String toString() {
        return "personnel{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", ID_number='" + ID_number + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", Face_ID='" + Face_ID + '\'' +
                ", address='" + address + '\'' +
                ", post='" + post + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getID_number() {
        return ID_number;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public personnel(String ID, String name, Integer age, String sex, String ID_number, String phone_number, String face_ID, String address, String post) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.ID_number = ID_number;
        this.phone_number = phone_number;
        this.Face_ID = null;
        this.address = address;
        this.post = post;
    }
}
