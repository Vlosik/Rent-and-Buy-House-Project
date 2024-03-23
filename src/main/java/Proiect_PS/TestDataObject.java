package Proiect_PS;

import jakarta.persistence.*;

@Entity
@Table(name="Test")
public class TestDataObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String column;
}
