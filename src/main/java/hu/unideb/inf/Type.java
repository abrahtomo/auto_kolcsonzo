package hu.unideb.inf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type {


    @Id
    @GeneratedValue
    private Long id;

    private String TypeName;

    public Type() {}

    public Type(String TypeName) {
        this.TypeName = TypeName;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }
}

