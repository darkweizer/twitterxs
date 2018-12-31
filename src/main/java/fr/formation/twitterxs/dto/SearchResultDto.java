package fr.formation.twitterxs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SearchResultDto<E> {

    private List<E> items;

    private Long totalElements;

    public SearchResultDto() {
    }

    public SearchResultDto(List<E> items, Long totalElements) {
        this.items = items;
        this.totalElements = totalElements;
    }
}
