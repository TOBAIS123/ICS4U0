// Erfan Yeganehfar
// Ms.Krasteva
// March 15th, 2019
// This interface defines the behaviour for classes the implememnt it allowing them to override the base behaviours of PersonalInfo

import java.util.Calendar;

interface PersonalInfo {

  // Abstract public methods that are to be overridden when the interface is implemented
  Calendar getFileCreationDate();
  int getCurrentAge(int birthYear);
}