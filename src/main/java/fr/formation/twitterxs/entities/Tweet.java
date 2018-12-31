package fr.formation.twitterxs.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"author_id", "postDate"}))
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User author;

    @EqualsAndHashCode.Include
    @Column(nullable = false, updatable = false)
    private LocalDateTime postDate;

    @Column(nullable = false)
    private LocalDateTime editDate;

    @Column(length = 280, nullable = false)
    private String content;
}
