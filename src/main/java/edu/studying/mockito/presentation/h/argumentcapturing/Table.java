package edu.studying.mockito.presentation.h.argumentcapturing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Table {

    private String name;
    private Integer number;
    private Integer time;
}
