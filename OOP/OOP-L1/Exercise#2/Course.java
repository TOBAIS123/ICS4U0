
public class Course {
  private String code;
  private String name;
  private String level;
  private float mark;
  private String status;
  private byte lates;
  private byte absences;

  public Course(String c, String n, String lev) {
    code = c;
    name = n;
    level = lev;
    mark = 0.0f;
    status = "";
    lates = 0;
    absences = 0;
  }

  public String getMarkG() {
    if (mark >= 95)
      return "A+";
    else if (mark >= 85)
      return "A";
    else if (mark >= 80)
      return "A-";
    else if (mark >= 75)
      return "B+";
    else if (mark >= 70)
      return "B";
    else if (mark >= 65)
      return "B-";
    else if (mark >= 60)
      return "C+";
    else if (mark >= 55)
      return "C";
    else if (mark >= 50)
      return "D";
    else
      return "F";
  }

  public float getMark() {
    return mark;
  }

  public String getStatus() {
    return status;
  }

  public String getLevel() {
    return level;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public byte getLates() {
    return lates;
  }

  public byte getAbsences() {
    return absences;
  }

  public void addLates(byte num) {
    lates += num;
  }

  public void addAbsences(byte num) {
    absences += num;
  }
  
  public boolean setStatus(String s) {
    if (s.equals("completed") || s.equals("enrolled") || s.equals("failed")) {
      status = s;
      return true;
    }
    return false;
  }

  public boolean setMark(float m) {
    if (m >= 0 && m <= 100) {
      mark = m;
      return true;
    }
    return false;
  }
}
