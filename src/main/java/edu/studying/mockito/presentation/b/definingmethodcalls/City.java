package edu.studying.mockito.presentation.b.definingmethodcalls;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private Country country;
    private String name;
    private Long population;

}
