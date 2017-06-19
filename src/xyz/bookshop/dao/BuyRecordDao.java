package xyz.bookshop.dao;

import xyz.bookshop.entity.Book;
import xyz.bookshop.entity.BuyRecord;
import xyz.bookshop.entity.User;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by PC on 2017/6/18.
 */
public class BuyRecordDao extends BaseDao{
    public BuyRecord find(String username) {
        try {
            ResultSet rs = this.select("select * from buyrecord where username=?",username);
            if (rs.next()) {
                return new BuyRecord(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getFloat(7),
                        rs.getString(8),
                        rs.getBinaryStream(9),
                        rs.getString(10)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
