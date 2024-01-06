package utilities;

public class QueryManage {


    private String supportTicketQuery = "SELECT * FROM support_tickets WHERE ticket LIKE '4%' LIMIT 1;";

    public String getSupportTicketQuery() {
        return supportTicketQuery;
    }


    private String setMobileUpdate = "UPDATE u168183796_qaloantec.users SET mobile = ?  WHERE username LIKE '%e_';";

    private String adminsQuery = "Select remember_token from admins  where email='info@loantechexper.com';";


    public String getAdminsQuery() {
        return adminsQuery;
    }


    public String getSetMobileUpdate() {
        return setMobileUpdate;
    }

    private String deleteLoanQuery = "DELETE FROM loans WHERE loan_number 'FOEYOKPQ3QEY';";

    public String getDeleteLoanQuery() {
        return deleteLoanQuery;
    }

    private String orderUsersQuery = " SELECT * FROM users ORDER BY lastname ASC, firstname DESC;";

    public String getOrderUsersQuery() {
        return orderUsersQuery;
    }

    private String deleteUpdateLogQuery = "DELETE * FROM update_log WHERE id = 18;";

    public String getDeleteUpdateLogQuery() {
        return deleteUpdateLogQuery;
    }

    private String depositsQuery = "Select user_id from deposits where amount  >100 and 500< amount;";

    public String getDepositsQuery() {
        return depositsQuery;
    }

    private String subscribersEmailNotLike = "select * from subscribers where email not like '%a%';";


    public String getSubscribersEmailNotLike() {
        return subscribersEmailNotLike;
    }

    private static String adminpasswordInsertQuery = "insert into admin_password_resets (email,token,status,created_at) values (?,?,?,?),(?,?,?,?);";

    public static String getAdminpasswordInsertQuery() {
        return adminpasswordInsertQuery;
    }


    private String supportMessagesQuery = "SELECT * FROM u168183796_qaloantec.support_messages WHERE message = '?'";


    public String getSupportMessagesQuery() {
        return supportMessagesQuery;

    }

    private String delayValueQuery = "SELECT  NAME FROM loan_plans ORDER BY delay_value LIMIT 3;";

    public String getDelayValueQuery() {
        return delayValueQuery;

    }

    private String fixedChargeQuery = "SELECT  NAME FROM loan_plans ORDER BY fixed_charge LIMIT 3;";

    public String getFixedChargeQuery() {
        return fixedChargeQuery;
    }

    private String percentChargeQuery = "SELECT  NAME FROM loan_plans ORDER BY percent_charge LIMIT 3;";

    public String getPercentChargeQuery() {
        return percentChargeQuery;
    }

}
