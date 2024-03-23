package co.cstad.spring_web_mvc.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

// Mark on class for generated database
@Entity
// Custom class
@Table(name = "categories")
public class Category {
    @Id
    // set strategy auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // length set size  & unique not can value doch kean & nullable flase trov tea mean value
    @Column(length = 40 , unique = true , nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
}
