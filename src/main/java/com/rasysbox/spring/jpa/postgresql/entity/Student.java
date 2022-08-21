package com.rasysbox.spring.jpa.postgresql.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name = "names")
    private String names;

    @Column(name = "age")
    private String age;

    @Column(name = "city")
    private String city;

    @Column(name = "time_zone")
    private String time_zone;

    @ManyToOne
    @JoinColumn(name = "question_fk")
    private Question question;
}
