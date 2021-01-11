package ws.parkingLotService.servlet;
public class AjaxMethodServlet
        {
        public AjaxMethodServlet()
        {
         //
         //TODO: 在此处添加构造函数逻辑
         //
         }
         [Ajax.AjaxMethod(Ajax.HttpSessionStateRequirement.Read)]
         public static String GetCardMoney(String cardNo,String cardPwd)
         {
         String mConn = IConfiguration.getParameter("connectString");
         IDBOSQL.IDBO dbo = IDBOSQL.IDBO.getIDBO(mConn);
         dbo.openDatabase();
         DataSet ds = dbo.executeSelectSql("select Card_Money,Service_Discount,Good_Discount from Table_CardInfo join Dic_CardType on Table_CardInfo.CardType_ID= Dic_CardType.CardType_ID where Card_NO='"+cardNo+"' and Card_Pwd= '"+cardPwd+"'and card_Status='正常'");
         DataTable dt = ds.Tables[0];
         String money = dt.Rows[0][0].ToString();
         String service_discount = dt.Rows[0][1].ToString();
         String good_discount = dt.Rows[0][2].ToString();
         dbo.closeDatabase();
         return money+","+service_discount+','+good_discount;//此处返回一个多个值拼接成的字符串
         }
        }

