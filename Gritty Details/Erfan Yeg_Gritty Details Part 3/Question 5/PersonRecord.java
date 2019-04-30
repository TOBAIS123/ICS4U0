// Erfan Yeganehfar
// Ms.Krasteva
// March 15th, 2019
// This class implements PersonalInfo to override the abstract methods and provide behaviours and instances to PersonRecord 

import java.util.Calendar;

public class PersonRecord implements PersonalInfo {
  private Calendar creationDate;
  private int currentAge;

  public PersonRecord() {
    creationDate = Calendar.getInstance();
    currentAge = 0;
  }
  // Overrides getFileCreationDate(), gets the file creation date
  @Override
  public Calendar getFileCreationDate() {
    return creationDate;
  }

  // Overrides getCurrentAge, gets the current age by finding the difference of the years (from the creationDate to the birthYear) 
  @Override
  public int getCurrentAge(int birthYear) {
    currentAge = creationDate.get(Calendar.YEAR) - birthYear;
    return currentAge;
  }
}