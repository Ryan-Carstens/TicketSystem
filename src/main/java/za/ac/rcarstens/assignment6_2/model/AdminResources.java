package za.ac.rcarstens.assignment6_2.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.rcarstens.assignment6_2.domain.FullName;
import za.ac.rcarstens.assignment6_2.domain.Login;
import za.ac.rcarstens.assignment6_2.domain.UserInterface;

/**
 * Created by student on 2015/08/20.
 */
public class AdminResources extends ResourceSupport implements UserInterface
{
    private Long resID;
    private Login LoginDeats;
    private FullName FullNameDeats;

    //Constructors
    private AdminResources() {

    }

    public AdminResources(Builder builder){
        this.resID=builder.resID;
        this.LoginDeats=builder.LoginDeats;
        this.FullNameDeats=builder.FullNameDeats;
    }


    //Get Methods
    public Long getID() {
        return resID;
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
    public static class Builder
    {
        private Long resID;
        private Login LoginDeats;
        private FullName FullNameDeats;

        public Builder(Login value) {
            this.LoginDeats = value;
        }

        public Builder resID(Long value){
            this.resID=value;
            return this;
        }

        public Builder FullNameDeats(FullName value){
            this.FullNameDeats=value;
            return this;
        }


        public Builder copy(AdminResources value){
            this.resID=value.resID;
            this.LoginDeats=value.LoginDeats;
            this.FullNameDeats=value.FullNameDeats;

            return this;
        }

        public AdminResources build(){
            return new AdminResources(this);
        }
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Admin_id='" + resID + '\'' +
                ", LoginDetails=" + LoginDeats +
                ", Fullname=" + FullNameDeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminResources admn = (AdminResources) o;

        if (resID != null ? !resID.equals(admn.resID) : admn.resID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return resID != null ? resID.hashCode() : 0;
    }
}
