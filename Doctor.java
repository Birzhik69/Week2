public class Doctor{
        private int DoctorID;
        private String DoctorName;
        private String Specialization;
        private int ExperienceYears;
        public int getDoctorID() {
            return DoctorID;
        }
    //Constructor
        public Doctor(int doctorID, String doctorName, String specialization, int experienceYears) {
            DoctorID = doctorID;
            DoctorName = doctorName;
            Specialization = specialization;
            ExperienceYears = experienceYears;
        }

        public void setDoctorID(int doctorID) {
            DoctorID = doctorID;
        }

        public String getDoctorName() {
            return DoctorName;
        }

        public void setDoctorName(String doctorName) {
            DoctorName = doctorName;
        }

        public String getSpecialization() {
            return Specialization;
        }

        public void setSpecialization(String specialization) {
            this.Specialization = specialization;
        }

        public int getExperienceYears() {
            return ExperienceYears;
        }

        public void setExperienceYears(int experienceYears) {
            this.ExperienceYears = experienceYears;
        }
        // To string
        @Override
        public String toString() {
            return "Doctor{" +
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
    }