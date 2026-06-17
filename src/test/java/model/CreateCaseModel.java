package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateCaseModel {
    String tittle;
    String note;
    List<String> point;
    List<String> difficult;
    String year;
    String month;
    String day;
    List<String> repeat;
    String repeatDay;
    String dayWeek;
    String tag;
}
