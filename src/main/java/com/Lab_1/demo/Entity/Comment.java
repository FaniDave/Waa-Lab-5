package com.Lab_1.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
}
