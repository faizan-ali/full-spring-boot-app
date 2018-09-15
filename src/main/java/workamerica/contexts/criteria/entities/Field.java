package workamerica.contexts.criteria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Faizan on 8/5/2016.
 */
@Entity
@Table(name = "Fields",  schema = "Criteria")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FieldID")
    private Long fieldID;
    @Column(name="Name")
    private String name;
    @Column(name = "Category")
    @JsonIgnore
    private String category;

    public Field() {}

    public Long getFieldID() {
        return fieldID;
    }

    public void setFieldID(Long fieldID) {
        this.fieldID = fieldID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
