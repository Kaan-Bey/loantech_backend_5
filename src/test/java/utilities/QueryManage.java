package utilities;

    public class QueryManage {




        private String supportTicketQuery = "SELECT * FROM support_tickets WHERE ticket LIKE '4%' LIMIT 1;" ;

        public String getSupportTicketQuery() {
            return supportTicketQuery;
        }

        private String adminsQuery= "Select remember_token from admins  where email='info@loantechexper.com';";

        public String getAdminsQuery() {
            return adminsQuery;
        }

/*
  private String studentsQuery = "Select * From u168183796_qawonder.students Where firstname= 'Brian' AND lastname= 'Kohlar'";

  private String onlineExamQuery = "SELECT exam ,AVG(passing_percentage) FROM u168183796_qawonder.onlineexam group by exam";

  private String rolesQuery = "INSERT INTO u168183796_qawonder.roles (name, is_active, is_system) values (?, ?, ?)";

  private String stafLeaveRequestQuery = "DELETE FROM u168183796_qawonder.staff_leave_request WHERE id= ?";




  //*********Getter**********

    public String getSupportTicketsQuery() {
        return supportTicketQuery;
    }

    public String getStudentsQuery() {
        return studentsQuery;
    }

    public String getOnlineExamQuery() {
        return onlineExamQuery;
    }

    public String getRolesQuery() {
        return rolesQuery;
    }

    public String getStafLeaveRequestQuery() {
        return stafLeaveRequestQuery;
    }


        //*********extra**********
        private String query="Select email FROM students where firstname='Brian' and lastname='Kohlar';";


        public String getQuery() {
            return query;
        }

     */
}
