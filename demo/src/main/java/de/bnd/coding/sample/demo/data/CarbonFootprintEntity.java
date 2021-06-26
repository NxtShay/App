package de.bnd.coding.sample.demo.data;

import javax.persistence.*;

@Entity

@Table( name = "carbonfootprints" )
public class CarbonFootprintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "name" )
    private String name;

    @Column( name = "footprint" )
    private Integer footprint;

    public CarbonFootprintEntity() {
    }

    public CarbonFootprintEntity(String name, Integer footprint) {
        this.name = name;
        this.footprint = footprint;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getFootprint() { return footprint; }

    public void setFootprint(Integer footprint) { this.footprint = footprint; }

}
