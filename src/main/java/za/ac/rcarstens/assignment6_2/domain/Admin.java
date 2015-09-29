package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by student on 2015/08/07.
 */
@Entity
public class Admin implements Serializable, UserInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Login LoginDeats;
    @Embedded
    private FullName FullNameDeats;

    //Constructors
    public Admin() {

    }

    public Admin(Builder builder){
        this.id=builder.id;
        this.LoginDeats=builder.LoginDeats;
        this.FullNameDeats=builder.FullNameDeats;
    }


    //Get Methods
    public Long getID() {
        return id;
    }

    public Login getLoginDeats()
    {
        return LoginDeats;
    }

    public FullName getFullNameDeats()
    {
        return FullNameDeats;
    }


    //Builder Subclass
    public static class Builder{
        private Long id;
        private Login LoginDeats;
        private FullName FullNameDeats;

        public Builder(Login value) {
            this.LoginDeats = value;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder FullNameDeats(FullName value){
            this.FullNameDeats=value;
            return this;
        }


        public Builder copy(Admin value){
            this.id=value.id;
            this.LoginDeats=value.LoginDeats;
            this.FullNameDeats=value.FullNameDeats;

            return this;
        }

        public Admin build(){
            return new Admin(this);
        }
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", LoginDeats=" + LoginDeats +
                ", FullNameDeats=" + FullNameDeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (id != null ? !id.equals(admin.id) : admin.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
