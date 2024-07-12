package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    /*
    [StudentID] INTEGER NOT NULL IDENTITY(1, 1),
    [name] VARCHAR(255) NULL,
    [gender] bit NULL,
    [dob] date,
    PRIMARY KEY ([StudentID])
     */

    private int StudentID;
    private String name;
    private int gender;
    private Date dob;

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
        try {
            Date dob = dateFormat.parse("2016-Mar-12");
            System.out.println(new StudentDTO(1, "kebian", 1, dob));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
