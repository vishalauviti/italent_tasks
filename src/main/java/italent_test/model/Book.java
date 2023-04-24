package italent_test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @JsonProperty("bookId")
    private int id;

    private String bookName;

    private String bookAuthor;

    private Date publishedDate;

    private double price;

    private String description;

    private int numberOfPages;

    private String language;

    private String publisher;

    private int rating;
}
