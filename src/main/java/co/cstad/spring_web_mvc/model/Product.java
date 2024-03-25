package co.cstad.spring_web_mvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.time.LocalDateTime;
import java.util.UUID;
//POJO
@NoArgsConstructor
@Getter
@Setter

@Entity
//@IdClass()

@Table(name = "products")
public class Product {
//    Primary
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    @Column(length = 40 , unique = true , nullable = false)
    private String name;
    private Double price;
    private Integer qty;
    private LocalDateTime  importedDate;
    private Boolean status;
}
