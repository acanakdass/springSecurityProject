package com.springapps.springSecurityProject.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor

public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
