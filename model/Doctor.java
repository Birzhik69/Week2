package model;

import hospitalmenu.Manageable;

public class Doctor implements Manageable {
        private int DoctorID;
        private String DoctorName;
        private String Specialization;
        private int ExperienceYears;
    //Constructor
    public Doctor(int doctorID, String doctorName, String specialization, int experienceYears) {
        setDoctorID(doctorID);
        setDoctorName(doctorName);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }


    public void setDoctorID(int doctorID) {
            if (doctorID <= 0 || doctorID >= 9999999) {
                System.out.println("Invalid model.Doctor ID");
                doctorID = 0;
            }
            DoctorID = doctorID;
        }

    public int getDoctorID() {
        return DoctorID;
    }

    public String getDoctorName() {
            return DoctorName;
        }

        public void setDoctorName(String doctorName) {
            if (doctorName != null && !doctorName.trim().isEmpty()) {
                this.DoctorName = doctorName;
            } else {
                System.out.println("Warning: Name cannot be empty!");
            }
        }

        public String getSpecialization() {
            return Specialization;
        }

        public void setSpecialization(String specialization) {
            if (specialization != null && !specialization.trim().isEmpty()) {
                this.Specialization = specialization;
            } else {
                System.out.println("Warning: Specialization cannot be empty!");
            }
        }

        public int getExperienceYears() {
            return ExperienceYears;
        }

        public void setExperienceYears(int experienceYears) {
            if (experienceYears >= 0) {
                this.ExperienceYears = experienceYears;
            } else {
                System.out.println("Experience Years cannot be negative! Setting to 0.");
                this.ExperienceYears = 0;
            }
        }
        // To string
        @Override
        public String toString() {
            return "model.Doctor{" +
                    "DoctorID=" + DoctorID +
                    ", DoctorName='" + DoctorName + '\'' +
                    ", Specialization='" + Specialization + '\'' +
                    ", ExperienceYears=" + ExperienceYears +
                    '}';
        }
        public String IsExperienced(){ //Checks if doctor is experienced
            if  (ExperienceYears >= 5) {
                return ("Well experienced");
            }
            else  {
                return ("Not well experienced");
            }
        }
        public String canPerformSurgery(){ //Checks if doctor can perform surgery
            if  (ExperienceYears >= 10) {
                return ("Can perform Surgery");
            }
            else  {
                return ("Cannot perform Surgery");
            }
        }
//Abstract class
    @Override
    public void startTreatment() {
        System.out.println(DoctorName + " has started treatment.");
    }

    @Override
    public void finishTreatment() {
        System.out.println(DoctorName + " has ended treatment.");
    }
}