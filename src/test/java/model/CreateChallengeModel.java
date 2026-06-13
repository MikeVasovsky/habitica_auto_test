package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateChallengeModel {
    String name;
    String shortName;
    String resume;
    String desk;
    String group;
    List<String> category;
    String gift;
}
