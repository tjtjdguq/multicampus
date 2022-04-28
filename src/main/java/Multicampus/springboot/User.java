package Multicampus.springboot;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity@Getter@Setter
public class User {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
}
