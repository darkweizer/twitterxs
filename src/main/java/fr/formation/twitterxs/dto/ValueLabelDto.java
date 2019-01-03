package fr.formation.twitterxs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValueLabelDto {

	private Object value;
	private String label;
	
	public ValueLabelDto() {
		
	}
	
	public ValueLabelDto(Object value, String label) {
		this.value = value;
		this.label = label;
	}
}
