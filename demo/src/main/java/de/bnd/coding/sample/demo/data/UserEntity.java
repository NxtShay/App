package de.bnd.coding.sample.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



// @Entity tells a JpaRepository that this corresponds to a database table
@Entity
// ... which is this table ;-)
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "firstname" )
    private String firstName;

    @Column( name = "lastname" )
    private String lastName;

    @Column( name = "username" , unique = true)
    private String userName;

    @Column( name = "userpassword" )
    private String userPassword;

    @Column( name = "zipcode" )
    private String zipCode = null;

    @Column( name = "peopleinhouse" )
    private Integer peopleInHouse = null;

    @Column( name = "heating" )
    private Boolean heating = null;

    @Column( name = "electricity" )
    private Boolean electricity = null;

    @Column( name = "car" )
    private String car = null;

    @Column( name = "kilometers" )
    private Integer kilometers = null;

    @Column( name = "holidaycar" )
    private Integer holidayCar = null;

    @Column( name = "holidayplane" )
    private Integer holidayPlane = null;

    @Column( name = "holidaytrain" )
    private Integer holidayTrain = null;

    @Column( name = "food" )
    private String food = null;

    @Column( name = "pvsystem" )
    private Boolean pvSystem = null;

    @Column( name = "recyclingglass" )
    private Boolean recyclingGlass = null;

    @Column( name = "recyclingplastic" )
    private Boolean recyclingPlastic = null;

    @Column( name = "recyclingpaper" )
    private Boolean recyclingPaper = null;

    @Column( name = "recyclingmetal" )
    private Boolean recyclingMetal = null;

    @Column( name = "recyclingfoodwaste" )
    private Boolean recyclingFoodwaste = null;

    @Column( name = "washing" )
    private String washing = null;

    @Column( name = "footprint" )
    private Integer footPrint = null;

    @Column( name = "score" )
    private Integer score;


    public UserEntity() {
    }

    public UserEntity(String userName, String userPassword, String firstName, String lastName) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

/*    public UserEntity(String userName, String userPassword, String firstName, String lastName, String zipCode) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }
 */

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

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

    public Integer getPeopleInHouse() { return peopleInHouse; }

    public void setPeopleInHouse(Integer peopleInHouse) { this.peopleInHouse = peopleInHouse; }

    public Boolean getHeating() { return heating; }

    public void setHeating(Boolean heating) { this.heating = heating; }

    public Boolean getElectricity() { return electricity; }

    public void setElectricity(Boolean electricity) { this.electricity = electricity; }

    public String getCar() { return car; }

    public void setCar(String car) { this.car = car; }

    public Integer getKilometers() { return kilometers; }

    public void setKilometers(Integer kilometers) { this.kilometers = kilometers; }

    public Integer getHolidayCar() { return holidayCar; }

    public void setHolidayCar(Integer holidayCar) { this.holidayCar = holidayCar; }

    public Integer getHolidayPlane() { return holidayPlane; }

    public void setHolidayPlane(Integer holidayPlane) { this.holidayPlane = holidayPlane; }

    public Integer getHolidayTrain() { return holidayTrain; }

    public void setHolidayTrain(Integer holidayTrain) { this.holidayTrain = holidayTrain; }

    public String getFood() { return food; }

    public void setFood(String food) { this.food = food; }

    public Boolean getPvSystem() { return pvSystem; }

    public void setPvSystem(Boolean pvSystem) { this.pvSystem = pvSystem; }

    public Boolean getRecyclingGlass() { return recyclingGlass; }

    public void setRecyclingGlass(Boolean recyclingGlass) { this.recyclingGlass = recyclingGlass; }

    public Boolean getRecyclingPlastic() { return recyclingPlastic; }

    public void setRecyclingPlastic(Boolean recyclingPlastic) { this.recyclingPlastic = recyclingPlastic; }

    public Boolean getRecyclingPaper() { return recyclingPaper; }

    public void setRecyclingPaper(Boolean recyclingPaper) { this.recyclingPaper = recyclingPaper; }

    public Boolean getRecyclingMetal() { return recyclingMetal; }

    public void setRecyclingMetal(Boolean recyclingMetal) { this.recyclingMetal = recyclingMetal; }

    public Boolean getRecyclingFoodwaste() { return recyclingFoodwaste; }

    public void setRecyclingFoodwaste(Boolean recyclingFoodwaste) { this.recyclingFoodwaste = recyclingFoodwaste; }

    public String getWashing() { return washing; }

    public void setWashing(String washing) { this.washing = washing; }

    public Integer getFootPrint() { return footPrint; }

    public void setFootPrint(Integer footPrint) { this.footPrint = footPrint; }

    public Integer getScore() { return score; }

    public void setScore(Integer score) { this.score = score; }
}
