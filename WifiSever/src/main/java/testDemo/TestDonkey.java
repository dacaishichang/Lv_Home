package testDemo;

import dao.DonkeyDao;
import dao.DonkeyHistoryDao;
import dao.UserDao;
import entity.Donkey;
import entity.DonkeyHistory;
import entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSession;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
import org.junit.Test;
import utils.DBUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.*;
/**
 * 传入RFID,检查唯一性
 * 	唯一：新建(size和性别选择)
 * 	不唯一：更新时间即可
 * 传入温度：
 * 	更新，温度和时间
 * 传入湿度：
 * 	更新，温度和时间
 * 传入光照：
 *  更新，温度和时间
 */

public class TestDonkey {

    @Test
    public void testHttp() throws Exception{
//        String url= "http://192.168.0.1/cgi-bin/node.cgi";
//        Document doc = Jsoup.connect(url).get();
//        System.out.println("body:"+doc.body());
//        System.out.println("text:"+doc.text());

        URL url=new URL("http://192.168.0.1/cgi-bin/node.cgi");
        BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
        String line=null;
        if((line=reader.readLine())!=null){
            System.out.println(line);
        }
        JSONArray json = JSONArray.fromObject(line);
        for(int i=0;i<json.size();i++){
            JSONObject job = json.getJSONObject(i);

            System.out.println(job) ;
        }

    }
    /**
     * 测试该RFID是否存在，存在则
     */
    @Test
    public void test2(){
        String RFIDInfo = "00 52 F2 CD 63";
        if(validateDonkeyByRFID(RFIDInfo)){
            System.out.println("已经存在");
            addDonkeyHistory(RFIDInfo);
        }else {
            System.out.println("还不存在");
            addDonkeyByFRID(RFIDInfo);
        }
    }

    @Test
    public void listUsers(){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserDao userMapper = sqlSession.getMapper(UserDao.class);
            List<User> userList = userMapper.select(new User());
            System.out.println(userList);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 测试RFID是否存在
     * @return
     */
    public static boolean validateDonkeyByRFID(String RFIDInfo){
        SqlSession sqlSession = null;
        int flag=0;
        try {
            sqlSession = DBUtils.openSqlSession();
            DonkeyDao donkeyDao = sqlSession.getMapper(DonkeyDao.class);
            Donkey donkey = new Donkey();
            donkey.setRFIDInfo(RFIDInfo);
            List<Donkey> donkeyList = donkeyDao.select(donkey);
//            System.out.println(donkeyList);
            flag=donkeyList.size();
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return 1==flag;
    }

    /**
     * 在确定RFID唯一（不在数据库）后，进行添加操作
     * @param RFIDInfo
     * @return
     */
    public static boolean addDonkeyByFRID(String RFIDInfo){
        SqlSession sqlSession = null;
        int flag=0;
        try {
            sqlSession = DBUtils.openSqlSession();
            DonkeyDao donkeyDao = sqlSession.getMapper(DonkeyDao.class);
            Donkey donkey = new Donkey();
            donkey.setRFIDInfo(RFIDInfo);
            donkey.setGender("雄");
            donkey.setSize(15l);
            flag = donkeyDao.insert(donkey);
            System.out.println(flag);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return 1==flag;
    }

    /**
     * 数据库已经存在，存入历史记录DonkeyHistory
     * @param RFIDInfo
     * @return
     */
    public static int addDonkeyHistory(String RFIDInfo){
        SqlSession sqlSession = null;
        int flag=0;
        Donkey donkey = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            DonkeyDao donkeyDao = sqlSession.getMapper(DonkeyDao.class);
            donkey = new Donkey();
            donkey.setRFIDInfo(RFIDInfo);
            List<Donkey> donkeyList = donkeyDao.select(donkey);
//            System.out.println(flag);
            donkey = donkeyList.get(0);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        //插入
        try {
            sqlSession = DBUtils.openSqlSession();
            DonkeyHistoryDao donkeyHistoryDao = sqlSession.getMapper(DonkeyHistoryDao.class);
            DonkeyHistory donkeyHistory = new DonkeyHistory();
            donkeyHistory.setRFIDInfo(donkey.getRFIDInfo());
            donkeyHistory.setSize(donkey.getSize());
            donkeyHistory.setDonkeyId(donkey.getDonkeyId());
            donkeyHistory.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            flag = donkeyHistoryDao.insert(donkeyHistory);
            System.out.println(flag);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return flag;
    }


}