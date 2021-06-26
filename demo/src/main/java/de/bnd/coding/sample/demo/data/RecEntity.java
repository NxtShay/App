package de.bnd.coding.sample.demo.data;

import javax.persistence.*;

@Entity
@Table( name = "recommondations" )
public class RecEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "recommondation" )
    private String recommondation;

    @Column( name = "basedon" )
    private String basedOn;

    @Column ( name = "zipcode" )
    private String zipCode;

    public RecEntity() {
    }

    public RecEntity(String recommondation, String basedOn, String zipCode) {
        this.recommondation = recommondation;
        this.basedOn = basedOn;
        this.zipCode = zipCode;
    }

    public String getRecommondation() { return recommondation; }

    public void setRecommondation(String recommondation) { this.recommondation = recommondation; }

    public String getBasedOn() { return basedOn; }

    public void setBasedOn(String basedOn) { this.basedOn = basedOn; }

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
}
