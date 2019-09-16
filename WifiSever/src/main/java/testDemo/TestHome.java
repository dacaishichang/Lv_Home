package testDemo;

import dao.HomeDao;
import dao.HomeHumidityHistoryDao;
import dao.HomeIlluminationHistoryDao;
import dao.HomeTemperatureHistoryDao;
import entity.Home;
import entity.HomeHumidityHistory;
import entity.HomeIlluminationHistory;
import entity.HomeTemperatureHistory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.DBUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestHome {
/*
不存在找不到，默认第一个驴舍（绑定HomeId）

对Home进行update
对其他的History进行插入

 */
    public static long homeIdChoose=1L;
    /**
     *
     * @param temperature
     * @return
     */
    public static boolean addAndUpdateTemperature(Float temperature){
        SqlSession sqlSession = null;
        int flag=0;
        try {
            sqlSession = DBUtils.openSqlSession();
            HomeDao homeDao = sqlSession.getMapper(HomeDao.class);
            Home home = new Home();
            home.setHomeId(homeIdChoose);
            home.setTemperature(temperature);
            flag = homeDao.update(home);
            System.out.println("更新了:"+flag);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if(flag==0){
            return false;
        }
        try {
            sqlSession = DBUtils.openSqlSession();
            HomeTemperatureHistoryDao homeTemperatureHistoryDao = sqlSession.getMapper(HomeTemperatureHistoryDao.class);
            HomeTemperatureHistory homeTemperatureHistory = new HomeTemperatureHistory();
            homeTemperatureHistory.setHomeId(homeIdChoose);
            homeTemperatureHistory.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            homeTemperatureHistory.setTemperature(temperature);
            flag = homeTemperatureHistoryDao.insert(homeTemperatureHistory);
            System.out.println("添加了:"+flag);
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
     * 插入和更新光照信息
     * @param illumination
     * @return
     */
    public static boolean addAndUpdateIllumination(Float illumination){
        SqlSession sqlSession = null;
        int flag=0;
        try {
            sqlSession = DBUtils.openSqlSession();
            HomeDao homeDao = sqlSession.getMapper(HomeDao.class);
            Home home = new Home();
            home.setHomeId(homeIdChoose);
            home.setIllumination(illumination);
            flag = homeDao.update(home);
            System.out.println("更新了:"+flag);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if(flag==0){
            return false;
        }
        try {
            sqlSession = DBUtils.openSqlSession();
            HomeIlluminationHistoryDao homeIlluminationHistoryDao = sqlSession.getMapper(HomeIlluminationHistoryDao.class);
            HomeIlluminationHistory homeIlluminationHistory = new HomeIlluminationHistory();
            homeIlluminationHistory.setHomeId(homeIdChoose);
            homeIlluminationHistory.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            homeIlluminationHistory.setIllumination(illumination);
            flag = homeIlluminationHistoryDao.insert(homeIlluminationHistory);
            System.out.println("添加了:"+flag);
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
     * 插入新的湿度历史，更新驴舍参数
     * @param humidity
     * @return
     */
    public static boolean addAndUpdateHumidity(Float humidity){
        SqlSession sqlSession = null;
        int flag=0;
        try {
            sqlSession = DBUtils.openSqlSession();
            HomeDao homeDao = sqlSession.getMapper(HomeDao.class);
            Home home = new Home();
            home.setHomeId(homeIdChoose);
            home.setHumidity(humidity);
            flag = homeDao.update(home);
            System.out.println("更新了:"+flag);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if(flag==0){
            return false;
        }
        try {
            sqlSession = DBUtils.openSqlSession();
            HomeHumidityHistoryDao homeHumidityHistoryDao = sqlSession.getMapper(HomeHumidityHistoryDao.class);
            HomeHumidityHistory homeHumidityHistory = new HomeHumidityHistory();
            homeHumidityHistory.setHomeId(homeIdChoose);
            homeHumidityHistory.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            homeHumidityHistory.setHumidity(humidity);
            flag = homeHumidityHistoryDao.insert(homeHumidityHistory);
            System.out.println("添加了:"+flag);
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

}
